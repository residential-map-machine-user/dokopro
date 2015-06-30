package DAOs;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import BaseClasses.BaseDAO;

public class JoinCategoryDAO extends BaseDAO{
	public int addUserToJoinCategoryTable(int userId, int categoryId){
		int successNum = 0;
		startConnection();
		String sql = "INSERT INTO table_join_category (user_id,category_id) values(?,?)";
		try {
			PreparedStatement pr = conn.prepareStatement(sql);
			int cnt = 1;
			pr.setInt(cnt++, userId);
			pr.setInt(cnt++, categoryId);
			successNum = pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return successNum;
	}
}
