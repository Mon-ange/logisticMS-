<%@page import="java.util.Hashtable"%>
<%@page import="java.util.List"%>
<%@page import="cn.brimon.model.User"%>
<%@page import="cn.brimon.service.OrderService"%>
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
		<h1 class="page-header">这是我的订单展示界面</h1>
		<table class="table">
			<thead>
				<tr>
					<th>单号</th>
					<th>订单名</th>
					<th>收货地址</th>
					<th>收货人</th>
					<th>联系电话</th>
					<th>状态</th>
					<th>位置</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<%
					User user = (User)session.getAttribute("user");
					user.myOrdersDisplay(request, response);
				%>
				<%=request.getAttribute("my_order_table")%>
			</tbody>
		</table>
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="outModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							订单出库
						</h4>
					</div>
					<form action="OutAction.do" method="post">
					<div class="modal-body">
						仓库：<input type="text" class="form-control" name="repository"><input type="hidden" id="order_id" name="order_id">
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