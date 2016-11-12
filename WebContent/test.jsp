<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="org.liufeng.weixin.thread.TokenThread" %>
    <%@page import="org.liufeng.weixin.thread.TicketThread" %>
    <%@page import="zmj.wx.utils.Sign" %>
    <%@page import="java.util.Map" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0">
</head>
<body>

<% String url = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+request.getServletPath().substring(0,request.getServletPath().lastIndexOf("/")+1);
if(request.getQueryString()!=null)
url+="?"+request.getQueryString();
pageContext.setAttribute("currenturl",url);
System.out.println("_+_+__+_+_+_+_+_+++++"+url);
//url = null;
String str = request.getParameter("nsukey");
//String str1 = new String(str.getBytes("ISO-8859-1"), "UTF-8");
System.out.println("访问结果："+str);
//System.out.println("访问结果："+str1);

%>

<script type="text/javascript">
alert(location.href.split('#')[0]);
</script>
<%="<script type=\"text/javascript\">" %>
<%="location.href.split('#')[0]" %>
<%="</script>" %>
<% System.out.println("=================="); %>
test <%=new java.util.Date() %>
<h3 id="menu-device">设备信息接口</h3>
      获取网络状态接口
      <button class="btn btn_primary" id="getNetworkType">getNetworkType</button>
<%
System.out.println("---------------------");

String   path   =   request.getContextPath();  
String   basePath   =   request.getScheme()+"://"+request.getServerName()+path+"/";  
//String   basePath   = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
System.out.println("basePath:"+basePath);

Map<String, String> ret = Sign.sign(TokenThread.jsapiTicket.getTicket(),basePath);
System.out.println("Token:"+TokenThread.accessToken.getToken() );
System.out.println("ticket:"+TokenThread.jsapiTicket.getTicket());
System.out.println("url:"+ret.get("url"));
System.out.println("jsapi_ticket:"+ret.get("jsapi_ticket"));
System.out.println("timestamp:"+ret.get("timestamp"));
System.out.println("nonceStr:"+ret.get("nonceStr"));
System.out.println("signature:"+ret.get("signature"));

%>
<br>
"Referer:"<%=request.getHeader("Referer")%><br>
"Token:"<%=TokenThread.accessToken.getToken()%><br>
"ticket:"<%=TokenThread.jsapiTicket.getTicket()%><br>
"url:"<%=ret.get("url")%><br>
"jsapi_ticket:"<%=ret.get("jsapi_ticket")%><br>
"timestamp:"<%=ret.get("timestamp")%><br>
"nonceStr:"<%=ret.get("nonceStr")%><br>
"signature:"<%=ret.get("signature")%><br>

<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script>
/*
 * 注意：
 * 1. 所有的JS接口只能在公众号绑定的域名下调用，公众号开发者需要先登录微信公众平台进入“公众号设置”的“功能设置”里填写“JS接口安全域名”。
 * 2. 如果发现在 Android 不能分享自定义内容，请到官网下载最新的包覆盖安装，Android 自定义分享接口需升级至 6.0.2.58 版本及以上。
 * 3. 常见问题及完整 JS-SDK 文档地址：http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html
 *
 * 开发中遇到问题详见文档“附录5-常见错误及解决办法”解决，如仍未能解决可通过以下渠道反馈：
 * 邮箱地址：weixin-open@qq.com
 * 邮件主题：【微信JS-SDK反馈】具体问题
 * 邮件内容说明：用简明的语言描述问题所在，并交代清楚遇到该问题的场景，可附上截屏图片，微信团队会尽快处理你的反馈。
 */
wx.config({
    debug: true,
    appId: 'wx9b04837925279ae8',
    timestamp: '<%=ret.get("timestamp")%>',
    nonceStr: '<%=ret.get("nonceStr")%>',
    signature: '<%=ret.get("signature")%>',
    jsApiList: [
      'checkJsApi',
      'onMenuShareTimeline',
      'onMenuShareAppMessage',
      'onMenuShareQQ',
      'onMenuShareWeibo',
      'onMenuShareQZone',
      'hideMenuItems',
      'showMenuItems',
      'hideAllNonBaseMenuItem',
      'showAllNonBaseMenuItem',
      'translateVoice',
      'startRecord',
      'stopRecord',
      'onVoiceRecordEnd',
      'playVoice',
      'onVoicePlayEnd',
      'pauseVoice',
      'stopVoice',
      'uploadVoice',
      'downloadVoice',
      'chooseImage',
      'previewImage',
      'uploadImage',
      'downloadImage',
      'getNetworkType',
      'openLocation',
      'getLocation',
      'hideOptionMenu',
      'showOptionMenu',
      'closeWindow',
      'scanQRCode',
      'chooseWXPay',
      'openProductSpecificView',
      'addCard',
      'chooseCard',
      'openCard'
    ]
});
</script>
<script src="js/demo.js"> </script>
<!-- 

 -->
 
</body>
</html>