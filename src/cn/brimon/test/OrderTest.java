package cn.brimon.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.brimon.model.Order;
import junit.framework.TestCase;

public class OrderTest {

	@Test
	public void test() {
		Order order = new Order();
		order.setOrderName("ʥ����ƻ��");
		TestCase.assertEquals(order.getOrderName(), "ʥ����");
		TestCase.assertEquals(order.getOrderName(), "ʥ����ƻ��");
		TestCase.assertNotNull(order.getOrderName());
	}

}
