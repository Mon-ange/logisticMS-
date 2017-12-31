package cn.brimon.service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import cn.brimon.dao.OrderDao;
import cn.brimon.dao.OrderDaoFactory;
import cn.brimon.model.Order;
import cn.brimon.model.User;

public class OrderService {
	public void addOrder(Order order) {
		OrderDao od = OrderDaoFactory.getDao();
		od.addOrder(order);
	}
	public Order getOrderById(Integer id){
		OrderDao od = OrderDaoFactory.getDao();
		return od.getOrderById(id);
	}
	
	public List<Hashtable<String, String>> queryMyOrders(User create_user) {
		List<Hashtable<String,String>> ret = new ArrayList<Hashtable<String, String> >();
		OrderDao od = OrderDaoFactory.getDao();
		List<Order> orderList = od.getOrdersByCreateUser(create_user);
		for(Order order : orderList) {
			Hashtable<String,String> element = new Hashtable<String,String>();
			element.put("order_id", order.getOrderId().toString());
			element.put("order_name", order.getOrderName());
			element.put("destination", order.getDestination());
			element.put("receiver", order.getReceiver());
			element.put("contact", order.getContact());
			element.put("location", "");
			element.put("status", "");
			ret.add(element);
		}
		return ret;
	}
	
}
