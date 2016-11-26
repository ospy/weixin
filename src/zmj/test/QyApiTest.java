package zmj.test;

import net.sf.json.JSONObject;

import org.junit.Test;
import org.liufeng.weixin.pojo.QyAccessToken;
import org.liufeng.weixin.thread.TokenThread;
import org.liufeng.weixin.util.WeixinUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zmj.wx.qy.bean.ReqMessage;
import zmj.wx.qy.bean.Text;

public class QyApiTest {
	private static Logger log = LoggerFactory.getLogger(TokenThread.class);
	public static void main(String[] args) {
		String url ="https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&userid=USERID";
		QyAccessToken qyAccessToken = WeixinUtil.getQyAccessToken("WWe58ab50489f20d50", "eZhANM582wXvvbke2qMdImvPTn3ImM5BGrs1KvWguc8");
		if(qyAccessToken != null){
			url = url.replace("ACCESS_TOKEN", qyAccessToken.getToken()).replace("USERID", "MingHong");
			String content = WeixinUtil.getRequest(url, "GET", null);
			log.info(content);
		}else{
			log.info("qyAccessToken is null");
		}
	}
	
	//应用消息推送
	@Test
	public void testPostMessage(){
		ReqMessage reqMessage = new ReqMessage("ZhaoMinJun","","text",1000003,new Text("你的快递已到，请携带工卡前往邮件中心领取。"));
		JSONObject jsonObject = JSONObject.fromObject(reqMessage);
		System.out.println("jsonObject:"+jsonObject.toString());
		String url = " https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=ACCESS_TOKEN";
//		QyAccessToken qyAccessToken = WeixinUtil.getQyAccessToken("WWe58ab50489f20d50", "ZLoRz2lgrmen403hNC7bC4Ug9-DZmnsi0AQXYt0TY1c");
		QyAccessToken qyAccessToken = new QyAccessToken();
		qyAccessToken.setExpiresIn(7200*1000);
		qyAccessToken.setToken("jlBar4kHjR9q7EZpbbvLq9hrc0NbeWA2n9nu15GihLEFEC5j8LUH3lpszN4WKG9tiV7a3fLPLpI6mnKoW_yYRGYcb08p6YYTG0ydgYwkmJpbhIQkXvhO4aVUvjngC652vdQ0puECGN_J0GXlSVyp8gTw-t8NViuqMxvrP7aGg6e4QJFKD4uEkKXRCt_6yyputTUqLuww6nPX2admDxcMwi6vao2Z9Htj-EfaxExlJ0p7YXxHlDjW7vwgqzQCuWXqRNNJCy9hVlutosZSedjSx71v61Dd_tzUKHyUpRR_GBKcKImXQBGc6E5bPmda5Btx");
		if(qyAccessToken != null){
			System.out.println("ACCESS_TOKEN:"+qyAccessToken.getToken());
			url = url.replace("ACCESS_TOKEN", qyAccessToken.getToken());
			JSONObject jsonObject2 = WeixinUtil.httpRequest(url, "POST", jsonObject.toString());
			if(jsonObject2 != null){
				System.out.println("返回信息："+jsonObject2.toString());
				if(jsonObject2.getInt("errcode") != 0){
					log.error("应用消息推送失败 errcode:{} errmsg:{}", jsonObject2.getInt("errcode"), jsonObject2.getString("errmsg"));
				}
			}
		}
	}
	
	@Test
	public void testReplace(){
		String url = " https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN", "000");
		System.out.println(url);
	}

}
