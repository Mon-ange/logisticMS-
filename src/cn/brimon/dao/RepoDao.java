package cn.brimon.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import cn.brimon.model.Cargo;
import cn.brimon.model.Repo;
import cn.brimon.model.User;

public class RepoDao extends Dao {
	RepoDao() {
		super();
	}

	public List<Hashtable<String, String>> getAllReposAndCargos() {
		ResultSet rs = null;
		Statement stmt = null;
		List<Hashtable<String, String>> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"select a.cargo_id,a.cargo_quantity,a.repo_id,b.cargo_name,c.repo_name from cargo_repository a left JOIN cargo b on a.cargo_id = b.cargo_id LEFT JOIN repo c on a.repo_id = c.repo_id");
			while (rs.next()) {
				Hashtable<String, String> cargoDetail = new Hashtable<>();
				cargoDetail.put("cargo_id", rs.getString("cargo_id"));
				cargoDetail.put("cargo_quantity", rs.getString("cargo_quantity"));
				cargoDetail.put("repo_id", rs.getString("repo_id"));
				cargoDetail.put("cargo_name", rs.getString("cargo_name"));
				cargoDetail.put("repo_name", rs.getString("repo_name"));
				list.add(cargoDetail);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		return null;
	}

	public void addCargoByRepository(Cargo cargo, Repo repo, Integer quantity) {
		Statement stmt = null;
		List<Hashtable<String, String>> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			String str = String.format("insert into cargo_repository(cargo_id,repo_id,cargo_quantity) values('%s','%s','%s')",
					cargo.getCargoId(), repo.getRepoId(), quantity.toString());
			System.out.println("Execute: " + str);
			stmt.execute(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateCargoQuantityByRepository(Cargo cargo, Repo repo, Integer quantity) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			System.out.println("Execute: " + "update cargo_repository set cargo_quantity = cargo_quantity + " + quantity.toString()
										+ " where cargo_id = '" + cargo.getCargoId().toString() + "' and repo_id = '"
										+ repo.getRepoId().toString() + "'");
			stmt.execute("update cargo_repository set cargo_quantity = cargo_quantity + " + quantity.toString()
										+ " where cargo_id = '" + cargo.getCargoId().toString() + "' and repo_id = '"
										+ repo.getRepoId().toString() + "'");
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}
	
	public Hashtable<String,String > getCargosAndRepoById(String cargoId, String repoId){
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"select cargo_id,repo_id,cargo_quantity from cargo_repository" + 
				    " where cargo_id = " + cargoId + " and repo_id = " + repoId);
			if (rs.next()) {
				Hashtable<String, String> cargoDetail = new Hashtable<>();
				cargoDetail.put("cargoId", rs.getString("cargo_id"));
				cargoDetail.put("repoId", rs.getString("repo_id"));
				cargoDetail.put("quantity", rs.getString("cargo_quantity"));
				return cargoDetail;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		return null;
	}
	
	public Repo getRepoById(String repoId) {
		ResultSet rs = null;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"select * from repo" + 
				    " where repo_id = " + repoId);
			if (rs.next()) {
				Repo repo = new Repo();
				repo.setRepoId(rs.getInt("repo_id"));
				repo.setRepoName(rs.getString("repo_name"));
				return repo;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		return null;
	}
	
}
