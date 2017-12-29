<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>

<body>
	<form method = "post">
	<div id="order_info_div">
		<h1 class="page-header">新建订单</h1>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
				  <p>订单名:</p><input type="text" class="form-control " name="order_name"/>
				</div> 
			</div>
			<div class="row">
				<div class="col-md-4">
					<p>目的地：</p> <input type="text" class="form-control" name="destination"/><br>
				</div>
			</div>
		</div>
		<br>
		<!-- 始发地：<input type="text" name="outset"/>-->
		
		收货人：<input type="text" name><br>
		联系方式：<input type="text" name=""/><br>
		<input type="button" value="新增" onclick="addCargo()"/><br>
		货物:<input name="cargo_name" type="text"> 数量：<input id="num"><br>
		<input name="submit" type="submit" value="新建订单"/>
		</div>
	</div>
	</form>
</body>
</html>