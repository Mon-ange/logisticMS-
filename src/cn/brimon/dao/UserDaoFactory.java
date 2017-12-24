package cn.brimon.dao;

public class UserDaoFactory extends DaoFactory {
	static UserDao userDao = new UserDao();
	
	public static UserDao getDao(){
		return userDao;
	}
}
