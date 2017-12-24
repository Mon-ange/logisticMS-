package cn.brimon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Dao {
	
	protected Connection conn;
	Dao(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void getConnection() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://133.130.101.213/logisticms?" +
			        "user=lmsuser&password=lmsuser");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    ex.printStackTrace();
		}
	}
}
