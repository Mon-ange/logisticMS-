<%@page import="cn.brimon.model.Repository"%>
<%@page import="cn.brimon.model.User"%>
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
		<h1 class="page-header">仓库管理</h1>
		<div class="row">
			<div class="col-md-2 col-md-offset-10" >
				<input type="button" onclick="javascript:" class="btn btn-primary pull-right" value="入库"/>
			</div>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>货物编号</th>
					<th>货物名称</th>
					<th>仓库编号</th>
					<th>仓库名称</th>
					<th>数量</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<%
					Repository repo = (Repository)session.getAttribute("user");
					repo.repositoryDisplay(request, response);
				%>
				<%=request.getAttribute("repo_table") %>
			</tbody>
		
		</table>
	</div>
	<div class="modal fade" id="cargoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
					<form action="UpdateOrderAction.do" method="post">
					<div class="modal-body">
						当前位置：<input type="text" class="form-control" name="location_name"><input type="hidden" id="update_order_id" name="order_id">
						路段成本：<input type="text" class="form-control" name="cost">
						距离：<input type="text" class="form-control" name="distance">
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