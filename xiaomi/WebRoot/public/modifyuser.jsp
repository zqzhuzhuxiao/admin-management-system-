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
    
    <title>修改账户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="./public/css/modify.css">
  </head>
  <script>
  function modify(){
  	var	userid = document.getElementById("userid").value;
  	var username = document.getElementById("username").value;
  	var password = document.getElementById("password").value;
  	if (password==''||username==''){
		alert("请完整输入！");
		return
	}else{
  	window.location.href='ModifyServlet?userid='+userid+'&password='+password+'&username='+username;
  	}
  }
  </script>
  <body>
    <%@ include file="../header.jsp"%>
    <div class="middle">
    <%@ include file="../admin_boss/user-left.jsp"%>
    <div class="modify">
	<div class="modify-pass">
		<h3>账户修改</h3>
        <form name="pd_add" action="ModifyServlet">
          <ul class="modify-input">
          <li>
              <p class="al">id名:</p>
              <%List<User> list = (List<User>)request.getAttribute("userlist");
               		User user = list.get(0); %>
              <input readonly="readonly" type="text" id="userid" value="<%=user.getUsername() %>"/>
            </li>
            <li>
              <p class="al">登录名:</p>
              <input type="text" id="username" value="<%=user.getUserid() %>"/>
            </li>
            <li>
              <p class="al">密码:</p>
              <input type="text" id="password" value="<%=user.getPassword() %>"/>
            </li>
          </ul>
          <p class="modify-title"><a href="javascript:modify();">修改</a></p>
        </form>
	</div>
</div>
    </div>
    <%@ include file="../footer.jsp"%>
  </body>
</html>
