package cn.brimon.service;

import java.util.Hashtable;
import java.util.List;

import cn.brimon.dao.CargoDao;
import cn.brimon.dao.CargoDaoFactory;
import cn.brimon.dao.RepoDao;
import cn.brimon.dao.RepoDaoFactory;
import cn.brimon.model.Cargo;

public class CargoService {

	public List<Hashtable<String, String> > queryReposAndCargos(){
		RepoDao rd = RepoDaoFactory.getDao();
		List<Hashtable<String,String> > list = rd.getAllReposAndCargos();
		return list;
	}
	
	
	public List<Cargo> queryCargos(){
		CargoDao cd = CargoDaoFactory.getDao();
		List<Cargo> list = cd.getAllCargos();
		return list;
	}
	
	public void addcargo(Cargo cargo) {
		CargoDao cd = CargoDaoFactory.getDao();
		cd.addCargo(cargo);
	}
	
	
	public Cargo getCargoById(String cargoId) {
		CargoDao cd = CargoDaoFactory.getDao();
		Cargo cargo = cd.getCargoById(cargoId);
		return cargo;
	}
	
}
