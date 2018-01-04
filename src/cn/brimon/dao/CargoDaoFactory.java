package cn.brimon.dao;

public class CargoDaoFactory extends DaoFactory {
	
	private static CargoDao cargoDao = new CargoDao();
	
	public static CargoDao getDao(){
		return cargoDao;
	}
}