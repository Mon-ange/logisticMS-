<%@page import="cn.brimon.model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Brimon物流</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>

<style type="text/css">
.jumbotron { background-image:url("img/index-bg.jpg"); margin-top: 50px;}
</style>

<body>

  <nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          	</button>
    		<a class="navbar-brand" href="#">Brimon</a>
    	</div>
    	<div class="navbar-right">
    		<ul class="nav navbar-nav">
    			<%
    				User user = (User)session.getAttribute("user");
    				if(user == null){
    					out.print("<li><a href= \"" + request.getContextPath() + "/login.jsp\">Login</a></li>");
    					out.print("<li><a href=\"" + request.getContextPath() + "/register.jsp\">Sign Up</a></li>");
    				}
    				else{
    					out.print(user.navBarDisplay());
    					out.print("<li><a href=\"LogOutAction.do\">Logout</a></li>");
    				}
    			%>
    			
    			
    		</ul>
    		
    	</div>
	</div>
    
</nav>
<div class="jumbotron" bgcolor="#000000">
	<div class="container">
		
		<form>
			<h1><br></h1>
			<h1><br></h1>
			<h2><br></h2>
			<div class="col-md-11"><input type="text" placeholder="Tracking Number" class="form-control"></div>
			<div class="col-md-1"><button type="button" class="btn btn-primary btn-log" >Track</button></div>
			<h1>&nbsp</h1>
		</form>
	
	</div>
	
	

</div>
	<div class="container">
		<div class="container col-md-4" >
			<div align="center"> <img src="img/description/img1.png"/></div>
			<div>
				<h1 align="center">服务范围</h1>
				<p>中国大陆及港澳地区，超过300个城市提供顺丰特惠服务，具体请咨询在线客服、95338或当地收派员。</p>
			</div>
		</div>
		<div class="container col-md-4">
			<div align="center"> <img src="img/description/img2.png"/></div>
			<div>
				<h1 align="center">递送承诺</h1>
				<p>在指定服务范围和寄递时间内收寄，根据寄件时间及快件寄/收地的行政区域，可查询明确的快件送达时间，最快隔日23：59前送达。</p>
			</div>
		</div>
		<div class="container col-md-4">
			<div align="center"> <img src="img/description/img3.png"/></div>
			<div>
				<h1 align="center">服务特性</h1>
				<p>√ 价格优惠，时效稳定；<br>
				   √ 当您寄递的快件发生损坏或遗失时，一经核实即可按照实际损失赔付，损坏最高可赔付200元，遗失最高可赔付500元；<br>
	               √ 寄递物品范围更广泛，包括液体、化妆品、锂电池和酒类等；<br>
	               √ 顺丰所有增值服务均支持。</p>
			</div>
		</div>
	</div>

</body>
</html>