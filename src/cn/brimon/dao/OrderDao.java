package cn.brimon.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import cn.brimon.model.Order;
import cn.brimon.model.User;

public class OrderDao extends Dao {

	OrderDao() {
		getConnection();
	}

	public Order getOrderById(Integer id) {
		ResultSet rs = null;
		Statement stmt = null;
		Order order = new Order();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM orders WHERE order_id = " + new Integer(id).toString());
			if (rs.next()) {
				order.setOrderId(id);
				order.setOrderName(rs.getString("order_name"));
				order.setCost(rs.getDouble("cost"));
				order.setDestination(rs.getString("destination"));
				// order.setCreateUser(rs.getInt("create_user"));
				order.setOutset(rs.getString("outset"));
				order.setComments(rs.getString("comments"));
				return order;
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			ex.printStackTrace();
		} 
		return null;
	}

	public void addOrder(Order order) {
		Statement stmt = null;
		try {

			stmt = conn.createStatement();
			String str = String.format(
					"INSERT INTO orders(order_name,cost,comments,create_user,destination,outset,contact,receiver,stat) "
							+ "VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s')",
					order.getOrderName(), order.getCost().toString(), order.getComments(),
					order.getCreateUser().getUserId(), order.getDestination(), order.getOutset(), order.getContact(),
					order.getReceiver(), "wait");
			stmt.execute(str);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Order> getOrdersByCreateUser(User create_user) {
		ResultSet rs = null;
		Statement stmt = null;
		List<Order> list = new ArrayList<Order>();
		try {
			stmt = conn.createStatement();
			System.out.println(
					"Execute:  " + "SELECT * FROM orders WHERE create_user = " + create_user.getUserId().toString());
			rs = stmt.executeQuery("SELECT * FROM orders WHERE create_user = " + create_user.getUserId().toString());

			while (rs.next()) {
				Order order = new Order();
				order.setOrderId(rs.getInt("order_id"));
				order.setOrderName(rs.getString("order_name"));
				order.setCost(rs.getDouble("cost"));
				order.setDestination(rs.getString("destination"));
				order.setReceiver(rs.getString("receiver"));
				order.setContact(rs.getString("contact"));
				order.setStat(rs.getString("stat"));
				list.add(order);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Order> getOrdersByStat(String...stat) {
		ResultSet rs = null;
		Statement stmt = null;
		List<Order> list = new ArrayList<Order>();
		try {
			stmt = conn.createStatement();
			String str = "SELECT * FROM orders WHERE '1'='1'";
			for(String s : stat) {
				str = str + "or stat = '" + s + "' ";
			}
			System.out.println("Execute:  " + str);
			rs = stmt.executeQuery(str);
			while (rs.next()) {
				Order order = new Order();
				order.setOrderId(rs.getInt("order_id"));
				order.setOrderName(rs.getString("order_name"));
				order.setCost(rs.getDouble("cost"));
				order.setDestination(rs.getString("destination"));
				order.setReceiver(rs.getString("receiver"));
				order.setContact(rs.getString("contact"));
				order.setStat(rs.getString("stat"));
				list.add(order);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void updateOrderStatByOrderId(String orderId, String stat) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			System.out.println("Execute:  " + "UPDATE orders SET stat = \'" + stat + "\' WHERE order_id = " + orderId);
			stmt.execute("UPDATE orders SET stat = \'" + stat + "\' WHERE order_id = " + orderId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}