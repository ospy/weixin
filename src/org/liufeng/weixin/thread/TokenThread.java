package org.liufeng.weixin.thread;

import org.liufeng.weixin.pojo.AccessToken;
import org.liufeng.weixin.pojo.JsapiTicket;
import org.liufeng.weixin.util.WeixinUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定时获取微信access_token的线程
 * 
 * @author liuyq
 * @date 2013-05-02
 */
public class TokenThread implements Runnable {
	private static Logger log = LoggerFactory.getLogger(TokenThread.class);
	// 第三方用户唯一凭证
	public static String appid = "";
	// 第三方用户唯一凭证密钥
	public static String appsecret = "";
	public static AccessToken accessToken = null;
	public static JsapiTicket jsapiTicket = null; //

	public void run() {
		while (true) {
			try {
				accessToken = WeixinUtil.getAccessToken(appid, appsecret);
				if (null != accessToken) {
					
					log.info("appid:{}", appid);
					log.info("appsecret:{}", appsecret);
					log.info("获取access_token成功，有效时长{}秒 token:{}", accessToken.getExpiresIn(), accessToken.getToken());
					
					//获取ticket
					jsapiTicket = WeixinUtil.getJsapiTicket(accessToken);
					if(jsapiTicket !=null){
						log.info("获取jsapiTicket成功，有效时长{}秒 ticket:{}", jsapiTicket.getExpiresIn(), jsapiTicket.getTicket());
					}else{
						// 如果jsapiTicket为null，30秒后再获取
						Thread.sleep(30 * 1000);
					}
							
							
					// 休眠7000秒
					Thread.sleep((accessToken.getExpiresIn() - 200) * 1000);
				} else {
					// 如果access_token为null，60秒后再获取
					Thread.sleep(60 * 1000);
				}
			} catch (InterruptedException e) {
				try {
					Thread.sleep(60 * 1000);
				} catch (InterruptedException e1) {
					log.error("{}", e1);
				}
				log.error("{}", e);
			}
		}
	}
}