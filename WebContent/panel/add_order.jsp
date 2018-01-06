<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>

<body>
	<form method = "post" action = "AddOrderAction.do">
	<div id="order_info_div">
		<h1 class="page-header">新建订单</h1>
		<div class="container_fluid" id="container">
			<div class="row">
				<div class="col-md-4">
				  <p>订单名:</p><input type="text" class="form-control " name="order_name"/>
				</div> 
			</div>
			<div class="row">
				<div class="col-md-4">
					<br>目的地： <input type="text" class="form-control" name="destination"/>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<br>收货人： <input type="text" class="form-control" name="receiver"/>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<br>联系方式:<input type="text" class="form-control" name="contact"/>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<br><input type="button" value="新增" class="btn btn-primary" onclick="addCargo()"/><br>
				</div>
			</div>
			<div id = "cargoList_div">
				<div class="row" id="addCargo_div">
					<br>
					<div class="col-md-4">
						货物:<input name="cargo_name" class="form-control" type="text">
					</div>
					<div class="col-md-1">
						 数量：<input id="num" class="form-control" >
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-1">
					<br><input name="submit" type="submit" class="btn btn-success"  value="新建订单"/>
				</div>
			</div>
		</div>
		<br>
		
		
		
		
		</div>
	
	</form>
</body>
</html>