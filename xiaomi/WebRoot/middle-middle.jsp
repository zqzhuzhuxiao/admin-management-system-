<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<style>
.middle-middle{
	margin-top: 5px;
	margin-left: 10px;	
}
.tu{
	width:3600px;
	position:absolute;
	left:0px;
	animation:huan 25s infinite;}
.img{
	width:720px;
	height:450px;
	float:left;}
.img img{
	width:100%;
	height:100%;}
.middle-middle{
	float:left;
	width:720px;
	height:450px;
	border:1px solid #000;
	position:relative;
	overflow:hidden;}
@keyframes huan{
	18%{left:0px;}
	20%,38%{left:-720px;}
	40%,58%{left:-1440px;}
	60%,78%{left:-2160px;}
	80%,100%{left:-2880px;}
	}
</style>
<div class="middle-middle">
	<div class="tu">
  		<div class="img"><img src="images/slider1.jpg"></div> 
  		<div class="img"><img src="images/slider2.jpg"></div>
 		<div class="img"><img src="images/slider3.jpg"></div>
  		<div class="img"><img src="images/slider4.jpg"></div>
  		<div class="img"><img src="images/slider5.jpg"></div></div>
</div>