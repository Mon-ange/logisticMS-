package cn.brimon.model;

public class Admin extends User {

	@Override
	public String toolBarDisplay() {
		// TODO Auto-generated method stub
		String ret = "<li><a>��ӭ�����𾴵Ĺ���Ա" + getUsername() + "</a></li>";
		return ret;
	}
	
}
