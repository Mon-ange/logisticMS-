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
<title>Insert title here</title>
</head>

<script type="text/javascript">
	function checkNav(){
		var nav = "<%=request.getParameter("nav")%>";
		if(nav == "my_order"){
			var elements = document.getElementsByClassName("active");
		    for(var i = 0 ; i < elements.length; i++){
		        elements[i].setAttribute("class", ""); 
		    }
		    var active_elements = document.getElementById("my_order");
		    active_elements.parentNode.setAttribute("class","active");
		    PanelShow(nav);
		}
		
	}
	function ToolBarRequest(){
	    var xmlhttp = new XMLHttpRequest();
	    xmlhttp.onreadystatechange = function(){
	        if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
	            document.getElementById("panel_div").innerHTML = xmlhttp.responseText;
	        }
	    }
	    xmlhttp.open("POST","order_manage.jsp",true);
	    xmlhttp.send();
	    
	}
	
	function setActive(obj){
	    var elements = document.getElementsByClassName("active");
	    for(var i = 0 ; i < elements.length; i++){
	        elements[i].setAttribute("class", ""); 
	    }
	    obj.parentNode.setAttribute("class","active");
	    
	}
	function PanelShow(nav){
	    var xmlHttp = new XMLHttpRequest();
	    xmlHttp.onreadystatechange = function(){
	        document.getElementById("main_div").innerHTML = xmlHttp.responseText;
	    }
	    xmlHttp.open("POST",nav + ".jsp",true);
	    xmlHttp.send();
	}
	function addCargo(){
		//alert("hello");
		var container = document.getElementById("cargoList_div");
		var cargo_div = document.getElementById("addCargo_div");
		cargo_div_clone = cargo_div.cloneNode("true");
		container.appendChild(cargo_div_clone);
	}
	function setOutOrder(order_id){
		var id_input = document.getElementById("order_id");
		id_input.setAttribute("value",order_id);
		$('#outModal').modal({});
	}
</script>
<body onload="checkNav()">
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>
    
    <div class="container-fluid">
    <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
          <%
          	User user = (User) session.getAttribute("user");
          	if(user == null){
          		response.sendRedirect(request.getContextPath()+"/login.jsp");
          	}	
          	else{
          		user.toolBarDisplay(request, response);
          	}
          	
          	
          %>
          <%=request.getAttribute("toolbarstr") %>
            <!-- <li name="selector"><a href="#" onclick="setActive(this)">Overview <span class="sr-only">(current)</span></a></li>
            <li name="selector" class="active"><a href="#" onclick="setActive(this)">Reports</a></li>
            <li><a href="#">Analytics</a></li>
            <li><a href="#">Export</a></li> -->
          </ul>
          <ul class="nav nav-sidebar">
          
            <li><a href="">Nav item</a></li>
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">Another nav item</a></li>
            <li><a href="">More navigation</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">Another nav item</a></li>
          </ul>
        </div>
    </div>
	
  	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" id="main_div">
  	</div>
	
	
</body>
</html>