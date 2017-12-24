package cn.brimon.model;

public abstract class User {
	private Integer userId;
	private String userName;
	private String passwd;

	public int getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return passwd;
	}

	public void setPassword(String passwd) {
		this.passwd = passwd;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User:\nuser_id=" + userId.toString() + "\nuser_name = " + userName;
	}

}
