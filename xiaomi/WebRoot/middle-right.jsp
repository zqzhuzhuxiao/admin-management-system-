<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script>
function login(){
	var id=document.getElementById("id").value;
	var password=document.getElementById("password").value;
	if (id=='' || password==''){
		alert("请完整输入！");
		return
	}
	else{
		window.location.href='LoginServlet?userid='+id+'&password='+password;
	}
}
</script>
<style>
input,li,p,td,th,ul {
    margin: 0;
    padding: 0;
}
li{
	list-style-type:none;}
a{
	text-decoration:none;
	background: #F0F8FF;}
.middle-right{
	width:300px;
	margin-top: 5px;
	margin-left: 10px;
	height:450px;
	border: 1px solid #000;
}
.login{
height: 240px;
padding-top:10px;}
.login-title{
	border-radius:8px;
	width:80%;
	margin: 0 auto;
	margin-bottom:10px;
	height: 30px;
	line-height: 30px;
	text-align: center;}
.login-input{
	width: 80%;
	margin: 0 auto;
	margin-top: 20px;
	margin-bottom: 10px;}
.login-input li{
	height:30px;
	line-height:30px;
	margin: 15px 0;
	font-size: 16px;}
.login-input input{
	height:30px;
	line-height:30px;
	width:75%;}
.login-btn{
	width: 90%;
	margin: 0 auto;}
.login-btn a{
	display: block;
	width: 45%;
	margin-left:5px;
	height:30px;
	line-height:30px;
	border-radius:5px;
	text-align: center;
	background:#F0F8FF;
	float: left;}
.login-on{
	margin-top:0;
	text-align: center;
	height: 150px;}
.login-on img{
	width: 120px;
	height: 120px;
	border-radius:60px;}
.login-on p{
	width:40%;
	margin:0 auto;
	height:30px;
	line-height:30px;
	float:left;
	margin-top: 10px;
	font-size: 18px;}
.user-name{
	text-align: right;
	color: #ffbb33;}
.loginout{
	border-radius:8px;
	width:80%;
	margin: 0 auto;
	height: 30px;
	line-height: 30px;
	text-align: center;
	margin-bottom:10px;}
.user{
	width: 90%;
	height: 40px;
	line-height: 40px;
	text-align: center;
	margin:0 auto;
	border-radius:5px;
	margin-bottom: 10px;}
</style>
<div class="middle-right">
	<%if (session.getAttribute("username")==null){ %>
      <div class="login">
        <p class="login-title">用户登录</p>
        <form >
          <ul class="login-input">
            <li>
              <label>账号：</label>
              <input type="text" id="id" value=""/>
            </li>
            <li>
              <label>密码：</label>
              <input type="password" id="password" value=""/>
            </li>
          </ul>
          <p class="login-title">忘记密码</p>
          <p class="login-btn">
            <a href="javascript:login()">登陆</a>
            <a href="/xiaomi/reguser/reguser.jsp">注册</a>
          </p>
        </form>
      </div>
      <%}else{ %>
      
      <div class="login">
        <dl class="login-on">
          <dt><img src="images/user-header.jpg" alt="头像" /></dt>
          <dd>
            <p class="user-name"><%=session.getAttribute("username") %></p>
            <p>您好！</p>
          </dd>
        </dl>      
        <p class="loginout"><a href="./ModifyServlet?userid=<%=session.getAttribute("userid") %>&action=usermod">修改账户</a></p>
      </div>
     <%} %>
   <div class="">
      	<p class="user"><a href="./CommServlet?commaddid=null&commaddname=null&action=find">商家管理(可用)</a></p>
   		<p class="user"><a href="/xiaomi/public/shop-cart.jsp">购物车(可用)</a></p>
   		<p class="user "><a href="./UserServlet?userid=null&username=null&action=find">管理员权限(可用)</a></p>
   		<p class="loginout"><a href="loginout.jsp">退出登录(可用)</a></p>
   </div>
</div>