package cn.brimon.service;

import java.util.Hashtable;

import cn.brimon.dao.RepoDao;
import cn.brimon.dao.RepoDaoFactory;
import cn.brimon.model.Cargo;
import cn.brimon.model.Repo;

public class RepositoryService {

	public void insertRepository(Cargo cargo, Repo repo, Integer quantity) {
		RepoDao rd = RepoDaoFactory.getDao();
		Hashtable<String, String> cr = rd.getCargosAndRepoById(cargo.getCargoId().toString(), repo.getRepoId().toString());
		if(cr != null)
			rd.updateCargoQuantityByRepository(cargo, repo, quantity);
		else
			rd.addCargoByRepository(cargo, repo, quantity);
		
	}
	
	public Repo getRepoById(String repoId) {
		RepoDao rd = RepoDaoFactory.getDao();
		Repo repo = rd.getRepoById(repoId);
		return repo;
	}
}
