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
	RepoDao(){
		super();
	}
	
	public List<Hashtable<String,String> > getAllReposAndCargos() {
		ResultSet rs = null;
		Statement stmt = null;
		List<Hashtable<String,String> > list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select a.cargo_id,a.cargo_quantity,a.repo_id,b.cargo_name,c.repo_name from cargo_repository a left JOIN cargo b on a.cargo_id = b.cargo_id LEFT JOIN repo c on a.repo_id = c.repo_id");
			while(rs.next()) {
				Hashtable<String,String> cargoDetail = new Hashtable<>();
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
}
