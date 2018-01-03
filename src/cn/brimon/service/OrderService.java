package cn.brimon.service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import cn.brimon.dao.LocationDao;
import cn.brimon.dao.LocationDaoFactory;
import cn.brimon.dao.OrderDao;
import cn.brimon.dao.OrderDaoFactory;
import cn.brimon.model.Location;
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
		else if(order.getStat().equals("running"))
			element.put("status", "运输中");
		else
			element.put("status", "未确认");
		element.put("location", "");
		return element;
	}
	
	public List<Hashtable<String, String>> queryMyOrders(User create_user) {
		List<Hashtable<String,String>> ret = new ArrayList<Hashtable<String, String> >();
		OrderDao od = OrderDaoFactory.getDao();
		LocationService ls = new LocationService();
		List<Order> orderList = od.getOrdersByCreateUser(create_user);
		for(Order order : orderList) {
			Hashtable<String,String> element = new Hashtable<String,String>();
			List<Location> locationList = ls.getOrderLocationByOrder(order);
			element = putOrderTableElement(order, element);
			if(locationList.size()>0)
				element.put("location", locationList.get(0).getLocationName());
			else
				element.put("location", "");
			ret.add(element);
		}
		return ret;
	}
	
	
	public List<Hashtable<String, String>> queryOutOrders(){
		List<Hashtable<String,String>> ret = new ArrayList<Hashtable<String, String> >();
		OrderDao od = OrderDaoFactory.getDao();
		List<Order> orderList = od.getOrdersByStat("wait","out");
		LocationService ls = new LocationService();
		for(Order order : orderList) {
			Hashtable<String,String> element = new Hashtable<String,String>();
			List<Location> locationList = ls.getOrderLocationByOrder(order);
			element = putOrderTableElement(order, element);
			if(locationList.size()>0)
				element.put("location", locationList.get(0).getLocationName());
			else
				element.put("location", "");
			ret.add(element);
		}
		return ret;
	}
	
	public List<Hashtable<String, String> > queryRunningOrders(){
		List<Hashtable<String,String>> ret = new ArrayList<Hashtable<String, String> >();
		OrderDao od = OrderDaoFactory.getDao();
		List<Order> orderList = od.getOrdersByStat("out","running");
		LocationService ls = new LocationService();
		for(Order order : orderList) {
			Hashtable<String,String> element = new Hashtable<String,String>();
			List<Location> locationList = ls.getOrderLocationByOrder(order);
			element = putOrderTableElement(order, element);
			if(locationList.size()>0)
				element.put("location", locationList.get(0).getLocationName());
			else
				element.put("location", "");
			ret.add(element);
		}
		return ret;
	}
	
	public void RunOrderService(Order order) {
		OrderDao dao = OrderDaoFactory.getDao();
		dao.updateOrderStatByOrderId(order.getOrderId().toString(), "running");
	}
	
	public void OutOrderService(Order order,Location location) {
		OrderDao od = OrderDaoFactory.getDao();
		od.updateOrderStatByOrderId(order.getOrderId().toString(), "out");
		LocationDao ld = LocationDaoFactory.getDao();
		ld.setLocationByOrder(order, location);
	}
	
	public Order getOrderByOrderId(Integer order_id) {
		OrderDao od = OrderDaoFactory.getDao();
		return od.getOrderById(order_id);
	}
	
	public void OrderAddCost(Order order,Double cost) {
		OrderDao od = OrderDaoFactory.getDao();
		od.addCostByOrder(order, cost);
	}
	
	
	
}
