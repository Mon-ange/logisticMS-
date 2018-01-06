<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method = "post" action = "AddLawAction.do">
	<div id="order_info_div">
		<h1 class="page-header">新增法律法规</h1>
		<div class="container_fluid" id="container">
			<div class="row">
				<div class="col-md-4">
				  <p>法规名:</p><input type="text" class="form-control " name="title"/>
				</div> 
			</div>
			<div class="row">
				<div class="col-md-4">
					<br>法规内容： <textarea class="form-control" name="content"></textarea>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-4">
					<input type="submit" class="btn btn-success"/>
				</div>
			</div>
			
		</div>
	</div>
	</form>
</body>
</html>