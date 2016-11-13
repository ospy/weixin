package zmj.test;

import org.liufeng.weixin.pojo.AccessToken;
import org.liufeng.weixin.thread.TokenThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WechatTest {
	private static Logger log = LoggerFactory.getLogger(WechatTest.class);
	public static void main(String[] args){
		log.debug("test-------------");
		AccessToken at = TokenThread.accessToken;
		System.out.println(at);
		
//		String token = TokenThread.accessToken.getToken();
//		System.out.println(token);
	}
}
