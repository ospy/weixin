<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%
String yibaokahao = request.getParameter("yibaokahao");
String shenfenzhenghao = request.getParameter("shenfenzhenghao");
System.out.println("yibaokahao:"+yibaokahao);
System.out.println("shenfenzhenghao:"+shenfenzhenghao);
%>
<%--=yibaokahao --%>
<%--=shenfenzhenghao --%>


<div class="demo">
        <table width="72%" height="256" class="bordered">
          <thead>
            <tr>
                <th width="10%">#</th>        
                <th width="40%">IMDB Top 10 Movies</th>
                <th width="50%">Year</th>
            </tr>
          </thead>
          <tbody>
                <tr>
              <td>1</td>        
              <td>The Shawshank Redemption</td>
               <td>1994</td>
            </tr>        
            <tr>
                <td>2</td>         
                <td>The Godfather</td>
                <td>1972</td>
            </tr>
            <tr>
                <td>3</td>         
                <td>The Godfather: Part II</td>
                <td>1974</td>
            </tr>    
            <tr>
                <td>4</td> 
                <td>The Good, the Bad and the Ugly</td>
                <td>1966</td>
            </tr>            
            </tbody>
        </table>
<p style="height: 50px"></p>
            <table class="zebra">
              <thead>
                <tr>
                     <th>#</th>        
                  <th>IMDB Top 10 Movies</th>
                  <th>Year</th>
                </tr>
              </thead>
            <tbody>
                    <tr>
                <td>1</td>        
                <td>The Shawshank Redemption</td>
                <td>1994</td>
                </tr>        
                <tr>
                <td>2</td>         
                <td>The Godfather</td>
                <td>1972</td>
                </tr>
                <tr>
                <td>3</td>         
                <td>The Godfather: Part II</td>
                <td>1974</td>
                </tr>    
                <tr>
                <td>4</td> 
                <td>The Good, the Bad and the Ugly</td>
                <td>1966</td>
                </tr>
                <tr>
                <td>5</td> 
                <td>The Good, the Bad and the Ugly</td>
                <td>1966</td>
                </tr>
                <tr>
                <td>6</td> 
                <td>The Good, the Bad and the Ugly</td>
                <td>1966</td>
                </tr>
                <tr>
                <td>7</td> 
                <td>The Good, the Bad and the Ugly</td>
                <td>1966</td>
                </tr>
                </tbody>
                <tfoot>
                <tr>
                <td>合计</td>        
                <td></td>
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