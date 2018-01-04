package cn.brimon.service;

import java.util.Hashtable;
import java.util.List;

import cn.brimon.dao.RepoDao;
import cn.brimon.dao.RepoDaoFactory;

public class CargoService {

	public List<Hashtable<String, String> > queryCargos(){
		RepoDao rd = RepoDaoFactory.getDao();
		List<Hashtable<String,String> > list = rd.getAllReposAndCargos();
		return list;
	}
	
}
