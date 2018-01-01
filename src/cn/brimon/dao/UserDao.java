package cn.brimon.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.brimon.model.User;

public class UserDao extends Dao {
	UserDao(){
		super();
	}
	public User getUserByUserNamePasswd(String userName,String passwd) {
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM users WHERE user_name = '" + userName + "' and " + "passwd = '" + passwd+"'");
			if(rs.next()) {
				User user = (User)Class.forName("cn.brimon.model." + rs.getString("user_type")).newInstance();
				user.setUserName(rs.getString("user_name"));
				user.setUserId(rs.getInt("user_id"));
				user.setPasswd(rs.getString("passwd"));
				return user;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("SQLException: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
		
	}
	public User getUserByUserId(Integer userId) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM users WHERE user_id = '" + userId.toString() + "'");
			if(rs.next()) {
				User user = (User)Class.forName("cn.brimon.model." + rs.getString("user_type")).newInstance();
				user.setUserName(rs.getString("user_name"));
				user.setUserId(rs.getInt("user_id"));
				user.setPasswd(rs.getString("passwd"));
				return user;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return null;
	}
}
