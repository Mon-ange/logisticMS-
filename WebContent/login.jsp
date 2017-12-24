<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="./css/bootstrap.min.css">
<!DOCTYPE html PUBtrC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>Insert title here</title>
</head>
<style>
  html {
			background: url(img/login_background.jpg) no-repeat center center fixed; 
			-webkit-background-size: cover;
			-moz-background-size: cover;
			-o-background-size: cover;
			background-size: cover;
		}
  body {
			padding-top: 60px;
			background: transparent;
		}
  .margin-base-vertical {
			margin: 40px 0;
		}
  .margin-font-vertical {
			margin: 5px 0;
		}
  .panel {
			background-color: rgba(255, 255, 255, 0.5);
		}
  </style>
<body>
<form action="loginAction.do" method="post">
	<!--  <table>
		<tr>
			<td>用户名：</td><td><input type="text" name="user_name" ></td>
		</tr>
		<tr>
			<td>密码：</td><td><input type="text" name="passwd"></td>
		</tr>
		<tr>
			<td align="center" colspan="2"><input type="submit" ></td>
		</tr>
	</table>
	-->
	<div class="container">
    	
    	
    	<div clas="row">
		    <div class="col-md-6 col-md-offset-3 row-md-offset-3 panel panel-default">
		    	<h1 class="margin-base-vertical text-center">用户登录</h1>
			    <form action="loginAction" method="post" class="margin-base-vertical">
			    	
			    	<div class="margin-font-vertical">用户名：</div>
			    	<div class="input-group">
			    		<span class="input-group-addon glyphicon glyphicon-user"></span>
			    		<input id="username" name="user_name" type="text" class="form-control input-lg"/>
			    	</div>
			    	<div class="margin-font-vertical">密码：</div>
			    	<div class="input-group">
			    		<span class="input-group-addon glyphicon glyphicon-pencil"></span>
			    		<div><input id="password" name="passwd" type="password" class="form-control input-lg"/></div>
			    	</div>
			    	<p>
			    		<font size="2px" color="red"><s:property value="hint" />&nbsp</font>
			    	</p>
			    	<p class="text-center">
			    		<input type="submit" value="登录" class="btn btn-success btn-lg btn-block"/>
			    	</p>
			    	
			    	
			    </form>
		    </div>
		</div>
    </div>
</form>
</body>
</html>