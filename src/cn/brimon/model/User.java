package cn.brimon.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class User {
	private Integer userId;
	private String userName;
	private String passwd;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User:\nuser_id=" + userId.toString() + "\nuser_name = " + userName;
	}
	
	public abstract void myOrdersDisplay(HttpServletRequest req, HttpServletResponse res);
	
	public abstract String navBarDisplay(); 

	public abstract void toolBarDisplay(HttpServletRequest request,HttpServletResponse res);

}
