<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  //初始化一级类别
  window.onload=function(){
	  var xmlhttp;
	  if (window.XMLHttpRequest){
	    // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
	    xmlhttp=new XMLHttpRequest();
	  }else{
	    // IE6, IE5 浏览器执行代码
	    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  xmlhttp.onreadystatechange=function(){
	    if (xmlhttp.readyState==4 && xmlhttp.status==200){
	     // alert(xmlhttp.responseText);
	      var commodifylist=xmlhttp.responseText.split("/");
	      commodifylist.pop();
	      for(var i=0;i<commodifylist.length;i++){
	    	 document.getElementsByName("commone")[0].options.add(new Option(commodifylist[i],commodifylist[i]));
	    	 }
	    }
	  };
	  xmlhttp.open("GET","RegComm?parentid=0",true);
	  xmlhttp.send();
  };
 //图片预览 
  function imgpreview(files){
    if(files.length){
      var file = files[0];
      var reader = new FileReader();
      reader.readAsDataURL(file);
      reader.onload = function(){
    	  var img = document.getElementById("commpic");
        img.src = this.result;
        img.style.display="inline"; 
        document.getElementById("mainpic_rs").style.display="inline"; 
        document.getElementsByName("mainpic")[0].style.display="none"; 
      };

     }
  }
 
 //重选图片
 function img_reselect(){
	document.getElementsByName("mainpic")[0].click();
 }

 //生成二级菜单
   function comm_two(){
	var commone=document.getElementsByName("commone")[0].value;
	 var xmlhttp;
	  if (window.XMLHttpRequest)
	  {
	    // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
	    xmlhttp=new XMLHttpRequest();
	  }
	  else
	  {
	    // IE6, IE5 浏览器执行代码
	    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  xmlhttp.onreadystatechange=function(){
	    if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    //  alert(xmlhttp.responseText);
	      var commodifylist=xmlhttp.responseText.split("/");
	      commodifylist.pop();
	      document.getElementsByName("commtwo")[0].innerHTML = "";
	      for(var i=0;i<commodifylist.length;i++){
	    	  document.getElementsByName("commtwo")[0].options.add(new Option(commodifylist[i],commodifylist[i]));
	    	 }
	    }
	  };
	  xmlhttp.open("GET","RegComm?parentid="+commone,true);
	  xmlhttp.send();
  }


  </script>
  <body>
  <%@ include file="../header.jsp" %>
  <div class="middle">
   <%@ include file="user-left.jsp" %>
   <div class="right">
   	<h3>添加商品</h3>
   	<form name="pd_add" action="AddComm" method="post"  enctype="multipart/form-data"> 
          <ul class="data-input">
           <li>
              <dl>
                <dt>商品类别：</dt>
                <dd><select id="type" name="commone" onchange="comm_two()" >   
						<option value="">--请选择--</option></select>   
					<select id="type" name="commtwo" >   
						<option value="">--请选择--</option></select>   
					 </dd>
              </dl>
            </li>
            <li>
              <dl>
                <dt>商品名称：</dt>
                <dd><input type="text" name="commaddname"/></dd>
              </dl>
            </li>
             <li>
              <dl>
                <dt>商品价格：</dt>
                <dd><input type="text" name="commprice"/></dd>
              </dl>
            </li>
           <li>
              <dl>
                <dt>商品图片：</dt>
                <dd><input type="file" name="mainpic" accept="image/*" onchange="imgpreview(this.files)"/></dd>
                 <dd><img src="./img/data/img-data01.jpg" width="150" style="display:none;"  alt="头像" id="commpic"/></dd>
                <dd><input type="button" id="mainpic_rs" style="display:none;float: right;" onclick="img_reselect()" value="重选图片"/></dd>
              </dl>

            </li>
      
          
            <li>
              <dl>
                <dd><input class="btn1" type="button" value="添加" onclick="document.pd_add.submit();"/></dd>
                
              </dl>
            </li>
          </ul>
        </form>
   	</div>
   </div>
  <%@ include file="../footer.jsp" %>
  </body>
</html>
