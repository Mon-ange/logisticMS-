<%@page import="cn.brimon.model.Repository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<h1 class="page-header">货物管理</h1>
		<div class="row">
			<div class="col-md-2 col-md-offset-10" >
				<input type="button" onclick="javascript:addCargoModal()" class="btn btn-primary pull-right" value="新增货物"/>
			</div>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>货物编号</th>
					<th>货物名称</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<%
					Repository repo = (Repository)session.getAttribute("user");
					repo.cargoDisplay(request, response);
				%>
				<%=request.getAttribute("cargo_table") %>
			</tbody>
		
		</table>
	</div>
	<div class="modal fade" id="addCargoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							入库
						</h4>
					</div>
					<form action="AddCargoAction.do" method="post">
					<div class="modal-body">
						物品名称：<input type="text" class="form-control" name="cargo_name">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button type="submit" class="btn btn-primary" >
							提交更改
						</button>
					
					</div>
					</form>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
</body>
</html>