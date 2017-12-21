package cn.brimon.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.brimon.model.Order;
import junit.framework.TestCase;

public class OrderTest {

	@Test
	public void test() {
		Order order = new Order();
		order.setOrderName("Ê¥µ®½ÚÆ»¹û");
		TestCase.assertEquals(order.getOrderName(), "Ê¥µ®½Ú");
		TestCase.assertEquals(order.getOrderName(), "Ê¥µ®½ÚÆ»¹û");
		TestCase.assertNotNull(order.getOrderName());
	}

}
