<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<style>
.user-left{
width: 200px;
height: 400px;
border: 1px #c3c3c3 solid;
float: left;
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
	width: 45%;}
.user-name{
	text-align: right;
	margin-right: 10px;
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
<div class="user-left">
<dl class="login-on">
          <dt><img src="./images/user-header.jpg" alt="头像" /></dt>
          <dd>
            <p class="user-name"><%=session.getAttribute("username") %></p>
            <p>您好！</p>
          </dd>
        </dl>
        <p class="commodify"><a href="/xiaomi/CommServlet?commaddid=null&commaddname=null&action=find">商品管理</a></p>
        <p class="commodify"><a href="/xiaomi/admin_business/commodify_add.jsp">商品添加</a></p>
</div>