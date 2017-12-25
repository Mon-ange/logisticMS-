package cn.brimon.model;

import javax.servlet.http.HttpServletRequest;

public class Admin extends User {

	@Override
	public String navBarDisplay() {
		// TODO Auto-generated method stub
		String ret = "<li><a>欢迎您，尊敬的管理员" + getUserName() + "</a></li>";
		return ret;
	}

	@Override
	public String toolBarDisplay(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String orderManageToolStr = "<a href=" + request.getContextPath() + "/order_manage.jsp" + ">订单管理</a>";
		String ret = orderManageToolStr;
		return ret;
	}

}
