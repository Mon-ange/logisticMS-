package cn.brimon.dao;

public class RepoDaoFactory extends DaoFactory {
	private static RepoDao  repoDao = new RepoDao();
	
	public static RepoDao getDao() {
		return repoDao;
	}
}
