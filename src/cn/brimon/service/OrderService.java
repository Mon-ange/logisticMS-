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
	
	private Hashtable<String,String> putOrderTableElement(Order order,Hashtable<String,String> element) {
		element.put("order_id", order.getOrderId().toString());
		element.put("order_name", order.getOrderName());
		element.put("destination", order.getDestination());
		element.put("receiver", order.getReceiver());
		element.put("contact", order.getContact());
		if(order.getStat().equals("wait"))
			element.put("status","等待出库");
		else if(order.getStat().equals("out"))
			element.put("status", "已出库");
		else
			element.put("status", "未确认");
		element.put("location", "");
		return element;
	}
	
	public List<Hashtable<String, String>> queryMyOrders(User create_user) {
		List<Hashtable<String,String>> ret = new ArrayList<Hashtable<String, String> >();
		OrderDao od = OrderDaoFactory.getDao();
		List<Order> orderList = od.getOrdersByCreateUser(create_user);
		for(Order order : orderList) {
			Hashtable<String,String> element = new Hashtable<String,String>();
			element = putOrderTableElement(order, element);
			ret.add(element);
		}
		return ret;
	}
	
	
	public List<Hashtable<String, String>> queryOutOrders(){
		List<Hashtable<String,String>> ret = new ArrayList<Hashtable<String, String> >();
		OrderDao od = OrderDaoFactory.getDao();
		List<Order> orderList = od.getOrdersByStat("wait","out");
		for(Order order : orderList) {
			Hashtable<String,String> element = new Hashtable<String,String>();
			element = putOrderTableElement(order, element);
			ret.add(element);
		}
		return ret;
	}
	
	public void OutOrderService(String orderId) {
		OrderDao od = OrderDaoFactory.getDao();
		od.updateOrderStatByOrderId(orderId, "out");
	}
}
