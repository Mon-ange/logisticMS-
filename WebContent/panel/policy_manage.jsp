<%@page import="cn.brimon.model.User"%>
<%@page import="cn.brimon.dao.UserDaoFactory"%>
<%@page import="cn.brimon.dao.UserDao"%>
<%@page import="cn.brimon.model.Law"%>
<%@page import="java.util.List"%>
<%@page import="cn.brimon.service.LawService"%>
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
		<h1 class="page-header">法律法规管理</h1>
		<table class="table">
			<thead>
				<tr>
					<th>编号</th>
					<th>法规名</th>
					<th>内容</th>
					<th>创建人</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<%
					LawService ls = new LawService();
					List<Law> list = ls.getAllLaws();
					for (Law law : list) {
						out.println("<tr>");
						out.println("<td>" + law.getLawId() + "</td>");
						out.println("<td>" + law.getTitle() + "</td>");
						out.println("<td>" + law.getContent() + "</td>");
						out.println("<td>" + law.getCreateUser().getUserName() + "</td>");
						out.println("<td><input type=\"button\" value=\"删除\" class=\"btn btn-danger\"/></td>");
						out.println("</tr>");
						
					}
				%>
			</tbody>
		</table>
</body>
</html>