<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script>
	function reg(){
	var name=document.getElementById("name").value;
	var id=document.getElementById("id").value;
	var password=document.getElementById("password").value;
	var rpassword=document.getElementById("rpassword").value;
	if (id=='' || password==''||name==''||rpassword==''){
		alert("请完整输入！");
		return
	}else	if(password!=rpassword){
		alert("两次密码不一致！");
	}else{
		window.location.href='RegServlet?userid='+id+'&password='+password+'&username='+name;
	}
}
</script>
<style>
.new-user{
	width:50%;
	height: 300px;
	margin: 0 auto;
	float:left;}
.middle-middle{
	padding-top:10px;
	padding-left:150px;
	width: 100%;
	height:100%;
	margin: 0 auto;}
.middle-middle h3{
	color: #a4b5c6;
	font-size: 24px;
	font-weight: 100;
	display: block;
	height: 30px;
	width: 100%;
}
.reg-title{
	width:80%;
	margin: 0 auto;
	height: 40px;
	background:  	#E1FFFF;
	line-height: 40px;
	font-size:18px;
	border-radius:5px;
	text-align: center; }
.reg-input li{
	width: 90%;
	height:40px;
	line-height:40px;
	margin:8px auto;
	text-align: center;}
.reg-input input{
	height:30px;
	line-height:30px;
	left:90px;
	float:left;
	width: 60%;
	margin-left: 10px;
	margin-top:5px;
	font-size: 18px;}	
.al{
	margin-left:20px;
	float:left;
	width:25%;
	text-align: left;
	height: 40px;
	line-height:40px; 
	font-size: 18px;}
</style>
<div class="new-user">
<div class="middle-middle">
	<h3>注册用户</h3>
        <form >
          <ul class="reg-input">
          <li>
              <p class="al">用户名:</p><input type="text" id="name" value=""/>
            </li>
            <li>
              <p class="al">登录名:</p><input type="text" id="id" value=""/>
            </li>
            <li>
              <p class="al">密码:</p><input type="text" id="password" value=""/>
            </li>
            <li>
              <p class="al">确认密码:</p><input type="text" id="rpassword" value=""/>
              
            </li>
          </ul>
          <p class="reg-title"><a href="javascript:reg()">注册</a></p>
        </form>
    </div>
</div>