package cn.brimon.model;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.brimon.display.CargoDisplayer;
import cn.brimon.display.MyOrderDisplayer;
import cn.brimon.display.NewOrderDisplayer;
import cn.brimon.display.RepositoryDisplayer;
import cn.brimon.display.ToolBarDisplayer;
import cn.brimon.service.OrderService;
import cn.brimon.service.CargoService;

public class Repository extends User {

	@Override
	public void myOrdersDisplay(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		String str = new String();
		OrderService os = new OrderService();
		List<Hashtable<String, String>> list = os.queryOutOrders();
		for (Hashtable<String, String> e : list) {
			String order_id = e.get("order_id");
			String order_name = e.get("order_name");
			String destination = e.get("destination");
			String receiver = e.get("receiver");
			String contact = e.get("contact");
			String status = e.get("status");
			String location = e.get("location");
			str = str.concat(
					"<tr><td>" + order_id + "</td>" + "<td>" + order_name + "</td>" + "<td>" + destination + "</td>");
			str = str.concat("<td>" + receiver + "</td>" + "<td>" + contact + "</td>" + "<td>" + status + "</td>");
			str = str.concat("<td>" + location + "</td>");
			str = str.concat("<td><input class=\"btn btn-success\" type=\"button\" onclick=\"javascript:setOutOrder("
					+ order_id + ")\" value=\"出库\">");
		}
		req.setAttribute("my_order_table", str);
	}

	@Override
	public String navBarDisplay() {
		// TODO Auto-generated method stub
		String ret = "<li><a>欢迎您，尊敬的仓库管理员" + getUserName() + "</a></li>";
		return ret;
	}

	@Override
	public void toolBarDisplay(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		List<ToolBarDisplayer> toolList = Arrays.asList(new MyOrderDisplayer(), 
														new RepositoryDisplayer(),
														new CargoDisplayer()
														);
		for (ToolBarDisplayer tool : toolList) {
			tool.display(req, res);
		}
	}

	public void repositoryDisplay(HttpServletRequest request, HttpServletResponse response) {
		String str = new String();
		CargoService cs = new CargoService();
		List<Hashtable<String,String> > list = cs.queryReposAndCargos();
		for (Hashtable<String, String> e : list) {
			String cargo_id = e.get("cargo_id");
			String cargo_name = e.get("cargo_name");
			String cargo_quantity = e.get("cargo_quantity");
			String repo_id = e.get("repo_id");
			String repo_name = e.get("repo_name");
			str = str.concat(
					"<tr><td>" + cargo_id + "</td>" + "<td>" + cargo_name + "</td>" + "<td>" + repo_id + "</td>");
			str = str.concat("<td>" + repo_name + "</td>");
			str = str.concat("<td>" + cargo_quantity + "</td>");
			str = str.concat("<td><input class=\"btn btn-success\" type=\"button\" onclick=\"javascript:setUpdateOrder()\" value=\"更新\">");
		}
		request.setAttribute("repo_table", str);
		//List<Hashtable<String, String>> list = os.queryCargos();
		
		
	}
	
	public void cargoDisplay(HttpServletRequest request, HttpServletResponse response) {
		String str = new String();
		CargoService cs = new CargoService();
		List<Cargo> list = cs.queryCargos();
		for (Cargo cargo : list) {
			String cargo_id = cargo.getCargoId().toString();
			String cargo_name = cargo.getCargoName().toString();
			str = str.concat(
					"<tr><td>" + cargo_id + "</td>" + "<td>" + cargo_name + "</td>");
			str = str.concat("<td><input class=\"btn btn-success btn-danger\" type=\"button\" onclick=\"javascript:deleteCargo()\" value=\"删除\">");
		}
		request.setAttribute("cargo_table", str);
		//List<Hashtable<String, String>> list = os.queryCargos();
	}

	
}
