<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="bean.User" %>
<style>
.left{
	width: 23%;
	float: left;}
.user-left{
width: 200px;
height: 300px;
border: 1px #c3c3c3 solid;
}
.login-on{
	width:90%;
	height: 150px;
	margin: 0 auto;
	border-bottom: 1px #c3c3c3 dashed;}
.login-on img{
	width: 80px;
	height: 80px;
	margin: 10px 50px;
	border-radius:40px;}
.login-on p{
	float: left;
	font-size: 18px;
	line-height: 40px;
	text-align:left;
	width: 40%;}
.user-name{
	margin-right: 10px;
	width: 60%;
	}
.commodify{
	width: 80%;
	margin: 0 auto;
	text-align: center;
	height: 40px;
	line-height: 40px;
	font-size: 18px;
	margin-top: 10px;
}
</style>
<div class="left">
<div class="user-left">
<dl class="login-on">
          <dt><img src="./images/user-header.jpg" alt="头像" /></dt>
          <dd>
            <p class="user-name"><%=session.getAttribute("username") %></p>
            <p>您好！</p>
          </dd>
        </dl>
        <p class="commodify"><a href="UserServlet?userid=null&username=null&action=find">用户管理</a></p>
        <p class="commodify"><a href="/xiaomi/reguser/reguser.jsp">用户添加</a></p>
</div>
</div>