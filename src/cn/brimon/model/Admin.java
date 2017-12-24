package cn.brimon.model;

public class Admin extends User {

	@Override
	public String toolBarDisplay() {
		// TODO Auto-generated method stub
		String ret = "<li><a>欢迎您，尊敬的管理员" + getUsername() + "</a></li>";
		return ret;
	}
	
}
