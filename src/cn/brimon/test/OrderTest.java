package cn.brimon.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.brimon.dao.Dao;
import cn.brimon.dao.OrderDao;
import cn.brimon.dao.UserDao;
import cn.brimon.dao.UserDaoFactory;
import cn.brimon.model.Order;
import cn.brimon.model.User;
import junit.framework.TestCase;

public class OrderTest {

	@Test
	public void test() {
		//UserDao ud = new UserDao();
		//User user = ud.getUserByUserNamePasswd("admin", "123456");
		//System.out.println(user);
		UserDao ud = UserDaoFactory.getDao();
		User user = ud.getUserByUserNamePasswd("admin", "123456");
		System.out.println(user);
	}

}
