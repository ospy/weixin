package zmj.test;



import org.liufeng.weixin.util.WeixinUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jTest {

	private static Logger log = LoggerFactory.getLogger(Log4jTest.class); 
	public static void main(String[] args) {
		
		log.info("test log");
		log.debug("debug test");
		log.error("error test");
	}

}
