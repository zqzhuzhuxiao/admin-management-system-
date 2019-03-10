<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>小米商城</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/index.css">
  </head>
  <body>
  	<%@ include file="header.jsp"%>
  	<div class="middle">
  		<div class="md">
  			<div class="ml"><%@ include file="middle-left.jsp"%></div>
  			<div class="ml"><%@ include file="middle-middle.jsp"%></div>
  			<div class="ml"><%@ include file="middle-right.jsp"%></div>
  		</div>
  		<%@ include file="shoping.jsp"%>
  		<div class="ms"><%@ include file="show.jsp"%></div>
  	</div>
  	
  	<%@ include file="footer.jsp"%>
  </body>
</html>
