package cn.brimon.dao;

public class LawDaoFactory extends DaoFactory {
	private static LawDao LawDao = new LawDao();
	public static LawDao getDao() {
		return LawDao;
	}
}
