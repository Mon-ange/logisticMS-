package cn.brimon.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import cn.brimon.model.Order;

public class OrderDao extends Dao {
	
	OrderDao(){
		getConnection();
	}
	
	public Order getOrderById(int id){
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
		}
		finally {
			try {
				if(rs.next()) {
					Order order = new Order();
					order.setOrderId(id);
					order.setOrderName(rs.getString("order_name"));
					order.setCost(rs.getInt("cost"));
					order.setDestination(rs.getString("destination"));
					//order.setCreateUser(rs.getInt("create_user"));
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

}
