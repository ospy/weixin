package zmj.wx.wechat;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import zmj.wx.utils.SHA1;



@SuppressWarnings("serial")
public class WechatCallbackApi extends HttpServlet {
	// 自定义 token
	private String TOKEN = "laozhao136786874";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 微信加密签名
		String signature = request.getParameter("signature");
		System.out.println(signature);
		// 随机字符串
		String echostr = request.getParameter("echostr");
		System.out.println(echostr);
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		System.out.println(timestamp);
		// 随机数
		String nonce = request.getParameter("nonce");
		System.out.println(nonce);
		String[] str = { TOKEN, timestamp, nonce };
		Arrays.sort(str); // 字典序排序
		String bigStr = str[0] + str[1] + str[2];
		// SHA1加密
		String digest = new SHA1().getDigestOfString(bigStr.getBytes()).toLowerCase();

		// 确认请求来至微信
		if (digest.equals(signature)) {
			response.getWriter().print(echostr);
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//处理接收消息    
        ServletInputStream in = request.getInputStream();  
        //将POST流转换为XStream对象  
        XStream xs = new XStream(new DomDriver());  
        //将指定节点下的xml节点数据映射为对象  
        xs.alias("xml", InputMessage.class);  
        //将流转换为字符串  
        StringBuilder xmlMsg = new StringBuilder();  
        byte[] b = new byte[4096];  
        for (int n; (n = in.read(b)) != -1;) {  
            xmlMsg.append(new String(b, 0, n, "UTF-8"));  
        }  
        //将xml内容转换为InputMessage对象  
        InputMessage inputMsg = (InputMessage) xs.fromXML(xmlMsg.toString());  
        // 取得消息类型  
        String msgType = inputMsg.getMsgType();  
        //根据消息类型获取对应的消息内容  
        if (msgType.equals(MsgType.Text.toString())) {  
            //文本消息  
            System.out.println("开发者微信号：" + inputMsg.getToUserName());  
            System.out.println("发送方帐号：" + inputMsg.getFromUserName());  
            System.out.println("消息创建时间：" + inputMsg.getCreateTime());  
            System.out.println("消息内容：" + inputMsg.getContent());  
            System.out.println("消息Id：" + inputMsg.getMsgId());  
        }  
	}
}
