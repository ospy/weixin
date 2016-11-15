<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
<link rel="stylesheet" href="css/weui.css"/>
<title>查询结果</title>
</head>
<body ontouchstart>
<%
String yibaokahao = request.getParameter("yibaokahao");
String shenfenzhenghao = request.getParameter("shenfenzhenghao");
System.out.println("yibaokahao:"+yibaokahao);
System.out.println("shenfenzhenghao:"+shenfenzhenghao);
%>
<%=yibaokahao %>
<%=shenfenzhenghao %>



<div class="weui-footer">
     <p class="weui-footer__text">Copyright &copy; 2016-2018 cdkangfu.com</p>
</div>

</body>
</html>