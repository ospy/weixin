package zmj.wx.qy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String sEchoStr; //需要返回的明文
		PrintWriter out = response.getWriter();
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		try {
			wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID);
			sEchoStr = wxcpt.VerifyURL(signature, timestamp, nonce, echostr);
			System.out.println("verifyurl echostr: " + sEchoStr);
			out.print(echostr);
		} catch (AesException e) {
			e.printStackTrace();
		}
		out.close();
		out = null;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
