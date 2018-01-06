<%@page import="cn.brimon.model.Law"%>
<%@page import="java.util.List"%>
<%@page import="cn.brimon.service.LawService"%>
<%@page import="cn.brimon.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/dashboard.css" rel="stylesheet">
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Brimon物流</title>
</head>

<script type="text/javascript">
	function checkNav(){
		var nav = "<%=request.getParameter("nav")%>";
		var elements = document.getElementsByClassName("active");
		for (var i = 0; i < elements.length; i++) {
			elements[i].setAttribute("class", "");
		}
		if (nav == "my_order") {
			var active_elements = document.getElementById("my_order");
			active_elements.parentNode.setAttribute("class", "active");
			PanelShow(nav);
		} else if (nav == "cargo_manage") {
			var active_elements = document.getElementById("cargo_manage");
			active_elements.parentNode.setAttribute("class", "active");
			PanelShow(nav);
		} else if (nav == "repository_manage") {
			var active_elements = document.getElementById("repository_manage");
			active_elements.parentNode.setAttribute("class", "active");
			PanelShow(nav);
		}else if (nav == "policy_manage") {
			var active_elements = document.getElementById("policy_manage");
			active_elements.parentNode.setAttribute("class", "active");
			PanelShow(nav);
		}
	}
	function ToolBarRequest() {
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("panel_div").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("POST", "order_manage.jsp", true);
		xmlhttp.send();
	}
	function setActive(obj) {
		var elements = document.getElementsByClassName("active");
		for (var i = 0; i < elements.length; i++) {
			elements[i].setAttribute("class", "");
		}
		obj.parentNode.setAttribute("class", "active");
	}
	function PanelShow(nav) {
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.onreadystatechange = function() {
			document.getElementById("main_div").innerHTML = xmlHttp.responseText;
		}
		xmlHttp.open("POST", nav + ".jsp", true);
		xmlHttp.send();
	}
	function addCargo() {
		//alert("hello");
		var container = document.getElementById("cargoList_div");
		var cargo_div = document.getElementById("addCargo_div");
		cargo_div_clone = cargo_div.cloneNode("true");
		container.appendChild(cargo_div_clone);
	}
	function setOutOrder(order_id) {
		var id_input = document.getElementById("order_id");
		id_input.setAttribute("value", order_id);
		$('#outModal').modal({});
	}
	function setUpdateOrder(order_id) {
		var id_input = document.getElementById("update_order_id");
		id_input.setAttribute("value", order_id);
		$('#updateModal').modal({});
	}
	function commentOrder(order_id) {
		var id_input = document.getElementById("comment_order_id");
		id_input.setAttribute("value", order_id);
		$('#commentModal').modal({});
	}
	function cargoModal() {
		$('#cargoModal').modal({});
	}
	function addCargoModal() {
		$('#addCargoModal').modal({});
	}
</script>
<body onload="checkNav()">
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="">Brimon</a>
		</div>
		
	</div>
	</nav>

	<div class="container-fluid">
		<div class="col-sm-3 col-md-2 sidebar">
			<ul class="nav nav-sidebar">
				<%
					User user = (User) session.getAttribute("user");
					if (user == null) {
						response.sendRedirect(request.getContextPath() + "/login.jsp");
					} else {
						user.toolBarDisplay(request, response);
					}
				%>
				<%=request.getAttribute("toolbarstr")%>
				<!-- <li name="selector"><a href="#" onclick="setActive(this)">Overview <span class="sr-only">(current)</span></a></li>
            <li name="selector" class="active"><a href="#" onclick="setActive(this)">Reports</a></li>
            <li><a href="#">Analytics</a></li>
            <li><a href="#">Export</a></li> -->
			</ul>
		</div>
	</div>

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" id="main_div">
	<h1>物流从业人员管理规定</h1>
	<%
			LawService ls = new LawService();
			List<Law> list = ls.getAllLaws();
			for (Law law : list) {
				out.println("<h3>" + law.getTitle() + "</h3>");
				out.println("<p>"+law.getContent() + "</p>");
			}
		%>

	</div>


</body>
</html>