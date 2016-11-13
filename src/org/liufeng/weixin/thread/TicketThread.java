package org.liufeng.weixin.thread;

import org.liufeng.weixin.pojo.JsapiTicket;
import org.liufeng.weixin.util.WeixinUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 定时获取微信jsapi_ticket的线程
 * @author Administrator
 * @date 2016-11-10
 */
public class TicketThread implements Runnable {

	private static Logger log = LoggerFactory.getLogger(TicketThread.class);

	
	public static JsapiTicket jsapiTicket  = null;

	public void run() {
		while (true) {
			try {
				jsapiTicket = WeixinUtil.getJsapiTicket(TokenThread.accessToken);
				if (null != jsapiTicket) {
					log.info("获取jsapi_ticket成功，有效时长{}秒 ticket:{}", jsapiTicket.getExpiresIn(), jsapiTicket.getTicket());
					// 休眠7000秒
					Thread.sleep((jsapiTicket.getExpiresIn() - 200) * 1000);
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
