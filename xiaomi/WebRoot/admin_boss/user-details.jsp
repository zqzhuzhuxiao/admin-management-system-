<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="bean.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>老板管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="./admin_boss/css/user.css">
  </head>
  <script>  
   function idfind(){    
   var userid = document.getElementById("userid").value;    
   window.location.href="UserServlet?userid="+userid+"&action=find";      
   }   
   function namefind(){     
   var username = document.getElementById("username").value;
  	window.location.href="UserServlet?username="+username+"&action=find";   
   } 
</script> 
  <body>
  <%@ include file="../header.jsp" %>
    <div class="middle">
		<%@ include file="user-left.jsp" %>
		<div class="right">
			<h3>用户管理</h3>
				<form>
				<p class="pl">请输入登录名:<input class="txt1" type="text" value="" id="userid" /><input type="button" value="精确查询" onclick="idfind()"/></p>
   				<p class="pl">请输入账户名:<input class="txt1" type="text" value="" id="username" /><input type="button" value="简易查询" onclick="namefind()"/></p>
				</form>
			<table class="userta">
			<tr><td>登录名</td><td>账户名</td><td>操作</td></tr>
			<%	List<User> list = (List<User>)request.getAttribute("userlist"); 
				for(int i=0;i<list.size();i++){ 
				User user1 = list.get(i);%>
				<tr>
					<td><%=user1.getUsername()%></td>
					<td><%=user1.getUserid()%></td>
					<td>
						<a href="ModifyServlet?userid=<%=user1.getUsername()%>&action=usermod">修改</a>
						<a href="UserServlet?userid=<%=user1.getUsername() %>&action=userdelete">删除</a>
					</td>
				</tr><%} %>
			</table>
		</div>
    </div>
  <%@ include file="../footer.jsp" %>
  </body>
</html>
