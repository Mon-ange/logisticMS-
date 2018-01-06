package cn.brimon.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.brimon.model.Law;

public class LawDao extends Dao {
	LawDao(){
		super();
	}
	
	public void insertLaw(Law law) {
		Statement stmt = null;
		try {

			stmt = conn.createStatement();
			String str = String.format(
					"INSERT INTO law(content,create_user,title) "
							+ "VALUES('%s','%s','%s')",
					law.getContent(),law.getCreateUser().getUserId(),law.getTitle());
			stmt.execute(str);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Law> getAllLaws() {
		ResultSet rs = null;
		Statement stmt = null;
		UserDao ud = UserDaoFactory.getDao();
		List<Law> list = new ArrayList<>();
		try {

			stmt = conn.createStatement();
			String str = String.format("SELECT * FROM law");
			rs = stmt.executeQuery(str);
			while(rs.next()) {
				Law law = new Law();
				law.setLawId(rs.getInt("law_id"));
				law.setContent(rs.getString("content"));
				law.setCreateUser(ud.getUserByUserId(rs.getInt("create_user")));
				law.setTitle(rs.getString("title"));
				list.add(law);
			}
			return list;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return null;
	}
	
}
