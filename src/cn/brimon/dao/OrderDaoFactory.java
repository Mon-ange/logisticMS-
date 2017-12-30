package cn.brimon.dao;

public class OrderDaoFactory extends DaoFactory {
	static OrderDao orderDao = new OrderDao();
	public static OrderDao getDao() {
		// TODO Auto-generated method stub
		return orderDao;
	}
}
