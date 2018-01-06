package cn.brimon.service;

import java.util.List;

import cn.brimon.dao.LawDao;
import cn.brimon.dao.LawDaoFactory;
import cn.brimon.model.Law;

public class LawService {
	public void insertLaw(Law law){
		LawDao ld = LawDaoFactory.getDao();
		ld.insertLaw(law);
	}
	
	public List<Law> getAllLaws(){
		LawDao ld = LawDaoFactory.getDao();
		return ld.getAllLaws();
	}
}
