<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="bean.comm.Commodify" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="./admin_business/css/add.css">
  </head>
  <script>
  function idfind(){
  var commid = document.getElementById("commid").value;
  window.location.href="CommServlet?commaddid="+commid+"&action=find";
  }
  function namefind(){
  var commname = document.getElementById("commname").value;
  window.location.href="CommServlet?commaddname="+commname+"&action=find";
  }
  function deletecomm(commaddid){
  window.location.href="CommServlet?commaddid="+commid+"&action=delete";
  }
  </script>
  <body>
  <%@ include file="../header.jsp" %>
   <div class="middle">
   	<%@ include file="user-left.jsp" %>
   	<div class="right">
   	<div class="on">
   	<h3>商品管理</h3>
   	<p class="pl">请输入产品id:
   		<input type="text" value="" id="commid" />
   		<input type="button" value="精确查询" onclick="idfind()"/></p>
   	<p class="pl">请输入产品名称:
   		<input type="text" value="" id="commname" />
   		<input type="button" value="简易查询" onclick="namefind()"/></p>
   	</div>
   	
   		<ul class="show-list">
   		<%	List<Commodify> list = (List<Commodify>)request.getAttribute("commlist"); 
				for(int i=0;i<list.size();i++){ 
				Commodify comm = list.get(i);%>
 			<li>
            <p><a href=""><img src="<%=comm.getCommurl() %>" alt="<%=comm.getCommaddname() %>" width="151" height="151" /></a></p>
            <p class="show-name"><%=comm.getCommaddname() %></p>
            <p class="show-price"><%=comm.getCommprice() %></p>
            <p><a href="CommServlet?commaddid=<%=comm.getCommaddid()%>&action=commdel">删除</a></p>
          </li><%} %>
        </ul>
   	</div>
   </div>
   <%@ include file="../footer.jsp" %>
  </body>
</html>
