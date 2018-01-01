package cn.brimon.model;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.brimon.display.CommentDisplayer;
import cn.brimon.display.MyOrderDisplayer;
import cn.brimon.display.NewOrderDisplayer;
import cn.brimon.display.OrderDisplayer;
import cn.brimon.display.OrderOutDisplayer;
import cn.brimon.display.RepositoryDisplayer;
import cn.brimon.display.ToolBarDisplayer;
import cn.brimon.service.OrderService;

public class Customer extends User {

	@Override
	public void myOrdersDisplay(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		String str = new String();
		OrderService os = new OrderService();
		List<Hashtable<String,String>> list = os.queryMyOrders(this);
		for(Hashtable<String,String> e : list){
			String order_id = e.get("order_id");
			String order_name = e.get("order_name");
			String destination = e.get("destination");
			String receiver = e.get("receiver");
			String contact = e.get("contact");
			String status = e.get("status");
			String location = e.get("location");
			str = str.concat("<tr><td>"+order_id+"</td>"+"<td>"+order_name+"</td>"+ "<td>"+destination+"</td>");
			str = str.concat("<td>"+receiver+"</td>"+"<td>"+contact+"</td>"+"<td>"+status+"</td>");
			str = str.concat("<td>"+location+"</td>");
			str = str.concat("<td><input class=\"btn btn-danger\"type=\"button\" value=\"撤单\">");
		}
		req.setAttribute("my_order_table", str);
	}

	@Override
	public String navBarDisplay() {
		// TODO Auto-generated method stub
		String ret = "<li><a>欢迎您，尊敬的用户" + getUserName() + "</a></li>";
		return ret;
	}

	@Override
	public void toolBarDisplay(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		List<ToolBarDisplayer> toolList = Arrays.asList(new NewOrderDisplayer(), new MyOrderDisplayer());
		for (ToolBarDisplayer tool : toolList) {
			tool.display(req, res);
		}
	}

}
