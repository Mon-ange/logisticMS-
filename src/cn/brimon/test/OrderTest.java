package cn.brimon.test;

import org.junit.Test;


import cn.brimon.dao.OrderDao;
import cn.brimon.dao.OrderDaoFactory;
import cn.brimon.model.Order;
public class OrderTest {

	@Test
	public void test() {
		// UserDao ud = new UserDao();
		// User user = ud.getUserByUserNamePasswd("admin", "123456");
		// System.out.println(user);
		// UserDao ud = UserDaoFactory.getDao();
		// User user = ud.getUserByUserNamePasswd("admin", "123456");
		// System.out.println(user);
		Order order = new Order();
		order.setOrderId(123456);
		order.setOrderName("222");
		order.setComments("999");
		OrderDao dao = OrderDaoFactory.getDao();
		dao.addOrder(order);
	}

}
