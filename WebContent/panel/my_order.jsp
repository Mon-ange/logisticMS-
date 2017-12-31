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
					OrderService os = new OrderService();
					List<Hashtable<String,String>> list = os.queryMyOrders((User)session.getAttribute("user"));
					for(Hashtable<String,String> e : list){
						String order_id = e.get("order_id");
						String order_name = e.get("order_name");
						String destination = e.get("destination");
						String receiver = e.get("receiver");
						String contact = e.get("contact");
						String status = e.get("status");
						String location = e.get("location");
						out.println("<tr><td>"+order_id+"</td>"+"<td>"+order_name+"</td>"+
									"<td>"+destination+"</td>");
						out.println("<td>"+receiver+"</td>"+"<td>"+contact+"</td>"+"<td>"+status+"</td>");
						out.println("<td>"+location+"</td>");
						out.println("<td><input class=\"btn btn-danger\"type=\"button\" value=\"撤单\">");
					}
				%>
			</tbody>
		</table>
	</div>
	
</body>
</html>