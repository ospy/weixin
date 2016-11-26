package zmj.wx.qy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.liufeng.course.util.MessageUtil;
import org.liufeng.course.util.SignUtil;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;

import zmj.wx.qy.util.QySignUtil;


@WebServlet("/QyCoreServlet")
public class QyCoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QyCoreServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sToken = "laozhao136786874";
		String sCorpID = "WWe58ab50489f20d50";
		String sEncodingAESKey = "6pD2igcIeAUiqqK8hovUGKMSgEGQod3obiClhdBhOk1";
		WXBizMsgCrypt wxcpt = null;
		// 微信加密签名
		String signature = request.getParameter("msg_signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");
//		String echostr_decoder = URLDecoder.decode(echostr, "UTF-8");
		
		System.out.println("-----------------");
		System.out.println("msg_signature："+ signature);
		System.out.println("timestamp："+ timestamp);
		System.out.println("nonce："+ nonce);
		System.out.println("echostr："+ echostr);
//		System.out.println("echostr_decoder："+ echostr_decoder);
		
		String sEchoStr; //需要返回的明文
		PrintWriter out = response.getWriter();
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		try {
			wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID);
			sEchoStr = wxcpt.VerifyURL(signature, timestamp, nonce, echostr);
//			String sEchoStr_Decode = wxcpt.VerifyURL(signature, timestamp, nonce, echostr_decoder);
			System.out.println("verifyurl echostr: " + sEchoStr);
//			System.out.println("verifyurl sEchoStr_Decode: " + sEchoStr_Decode);
			out.print(sEchoStr);
//			out.print(sEchoStr_Decode);
		} catch (AesException e) {
			e.printStackTrace();
		}
		out.close();
		out = null;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sToken = "laozhao136786874";
		String sCorpID = "WWe58ab50489f20d50";
		String sEncodingAESKey = "6pD2igcIeAUiqqK8hovUGKMSgEGQod3obiClhdBhOk1";
		WXBizMsgCrypt wxcpt = null;
		
		String msg_signature = request.getParameter("msg_signature");
		System.out.println("msg_signature------"+msg_signature);
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		System.out.println("timestamp------"+timestamp);
		// 随机数
		String nonce = request.getParameter("nonce");
		System.out.println("nonce------"+nonce);
		// xml请求解析
		try {
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			String toUserName = requestMap.get("ToUserName");
			System.out.println("toUserName------"+toUserName);
			String agentID = requestMap.get("AgentID");
			System.out.println("agentID------"+agentID);
			String encrypt =  requestMap.get("Encrypt");
			System.out.println("encrypt------"+encrypt);
			
			wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID);
			String decrypt = wxcpt.DecryptMsg2(msg_signature, timestamp, nonce, encrypt);
			
			System.out.println("decrypt------"+decrypt);
			
			String reContent="<xml><ToUserName><![CDATA[ZhaoMinJun]]></ToUserName> \n"
					+ "  <FromUserName><![CDATA[WWe58ab50489f20d50]]></FromUserName> \n"
					+ "   <CreateTime>1348831860</CreateTime> \n"
					+ "   <MsgType><![CDATA[text]]></MsgType> \n"
					+ "   <Content><![CDATA[this is a test]]></Content></xml>";
			PrintWriter out = response.getWriter();
			String responeText =  wxcpt.EncryptMsg(reContent, timestamp, nonce);
			System.out.println("responeText----------"+responeText);
			out.print(responeText);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
