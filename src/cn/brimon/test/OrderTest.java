package cn.brimon.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;


import cn.brimon.dao.OrderDao;
import cn.brimon.dao.OrderDaoFactory;
import cn.brimon.model.Order;
import junit.framework.TestCase;
public class OrderTest {

	@Test
	public void test() {
		// UserDao ud = new UserDao();
		// User user = ud.getUserByUserNamePasswd("admin", "123456");
		// System.out.println(user);
		// UserDao ud = UserDaoFactory.getDao();
		// User user = ud.getUserByUserNamePasswd("admin", "123456");
		// System.out.println(user);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdf.format(date);
		System.out.println(dateStr); 
	}

}
