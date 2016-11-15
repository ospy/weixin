<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="zmj.wx.database.DBPool" %>
    <%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
<link rel="stylesheet" href="css/weui.css"/>
<link rel="stylesheet" href="css/my.css"/>
<title>查询结果</title>
</head>
<body ontouchstart>

<div class="demo">    
            <table class="zebra">
              <thead>
                <tr>
                     <th width="4%">ID</th>        
                  <th width="66%">项目</th>
                  <th width="15%">数量</th>
                  <th width="15%">金额</th>
                </tr>
              </thead>
            <tbody>
<%
String yibaokahao = request.getParameter("yibaokahao");
String shenfenzhenghao = request.getParameter("shenfenzhenghao");
System.out.println("yibaokahao:"+yibaokahao);
System.out.println("shenfenzhenghao:"+shenfenzhenghao);

Connection conn;
Statement stmt = null;
ResultSet rs = null;
conn = DBPool.getInstance().getConnection();


try {
	stmt = conn.createStatement();
	String sql = "select row_number() over (order by drq) as rowid, * from yxybjk..TBMZFYMX_MID where cjzbh='00001402175073717'";
	rs = stmt.executeQuery(sql);
	while(rs.next()){
		%>
		  <tr>
                <td><%=rs.getString("rowid") %></td>        
                <td><%=rs.getString("cxmmc") %></td>
                <td><%=rs.getString("nsl") %></td>
				<td><%=rs.getString("msj") %></td>
                </tr> 
		
		<% 
	}

} catch (SQLException e) {
	e.printStackTrace();
}

%>
<%--=yibaokahao --%>
<%--=shenfenzhenghao --%>

                         
               
                </tbody>
                <tfoot>
                <tr>
                <td>&nbsp;</td>        
                <td>合计</td>
                <td>二恶</td>
                <td></td>
                </tr>
            </tfoot>
            </table>
    </div>


<div class="weui-footer">
     <p class="weui-footer__text">Copyright &copy; 2016-2018 cdkangfu.com</p>
</div>

</body>
</html>