package cn.brimon.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import cn.brimon.model.Location;
import cn.brimon.model.Order;
import cn.brimon.model.User;

public class LocationDao extends Dao {
	LocationDao() {
		super();
	}

	public List<Location> getLocationByOrder(Order order) {
		ResultSet rs = null;
		Statement stmt = null;
		List<Location> list = new ArrayList<Location>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from orders_location where order_id = " + order.getOrderId().toString()
					+ " ORDER BY timestamps DESC");
			while (rs.next()) {
				Location location = new Location();
				UserDao ud = UserDaoFactory.getDao();
				location.setLocationName(rs.getString("location_name"));
				User handle_user = ud.getUserByUserId(rs.getInt("handle_user"));
				location.setHandleUser(handle_user);
				location.setDistance(rs.getDouble("distance"));
				location.setTimestamps(rs.getDate("timestamps"));
				list.add(location);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void setLocationByOrder(Order order,Location location) {
		Statement stmt = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdf.format(location.getTimestamps());
		String str = String.format("insert orders_location(location_name,order_id,handle_user,distance,timestamps) "
									+ "values('%s','%s','%s','%s','%s')",location.getLocationName()
																	    ,order.getOrderId().toString()
																	    ,location.getHandleUser().getUserId().toString()
																  	    ,location.getDistance().toString()
																  	    ,dateStr);
		try {
			stmt = conn.createStatement();
			stmt.execute(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
