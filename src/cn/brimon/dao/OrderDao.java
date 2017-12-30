package cn.brimon.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import cn.brimon.model.Order;
import cn.brimon.model.User;

public class OrderDao extends Dao {

	OrderDao() {
		getConnection();
	}

	public Order getOrderById(int id) {
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM orders WHERE order_id = " + new Integer(id).toString());
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			ex.printStackTrace();
		} finally {
			try {
				if (rs.next()) {
					Order order = new Order();
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
		}
		return null;
	}

	public void addOrder(Order order) {
		Statement stmt = null;
		try {
			
			stmt = conn.createStatement();
			String str=String.format("INSERT INTO orders(order_name,cost,comments,create_user,destination,outset,contact) "
		   			   + "VALUES('%s','%s','%s','%s','%s','%s','%s')", order.getOrderName(),
		   			order.getCost().toString(),order.getComments(),order.getCreateUser().getUserId(),
		   			order.getDestination(),order.getOutset(),order.getContact());  
			stmt.execute(str);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	public List getOrdersByCreateUser(User create_user) {
		ResultSet rs = null;
		Statement stmt = null;
		return null;
	}
}