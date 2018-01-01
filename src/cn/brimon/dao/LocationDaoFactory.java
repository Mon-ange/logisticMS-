package cn.brimon.dao;

public class LocationDaoFactory {
	private static LocationDao locationDao = new LocationDao();
	public static LocationDao getDao() {
		return locationDao;
	}
}
