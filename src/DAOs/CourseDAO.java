package DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import BaseClasses.BaseDAO;
import Beans.CategoryBean;

public class CourseDAO extends BaseDAO {
	// 結局ここのDAOに付いてはほとんどデフォルトで表示しておくものなので最初はallで対応しておく

	/**
	 * カテゴリー
	 */
	// 増やす：カテゴリーを作る
	// 表示:カテゴリーを全件表示
	// 編集:カテゴリーを編集する
	// 消す:フラグで管理する

	// 追加系のメソッド
	public int addCategory(HttpServletRequest request) {
		int successNum = 0;

		startConnection();
		try {
			String categoryName = request.getParameter("CATEGORY_NAME");
			String belongTo = request.getParameter("BELONG_TO");
			String sql = "INSERT INTO table_category (category_name,belong_to) values(?,?);";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			int ctn = 1;
			prstmt.setString(ctn++, categoryName);
			prstmt.setString(ctn++, belongTo);
			successNum = prstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return successNum;
	}

	// セレクト系のメソッド
	public List<CategoryBean> selectAllCategory() {
		ResultSet rs = null;
		startConnection();
		List<CategoryBean> categoryList = new ArrayList<>();
		try {
			String sql = "select * from table_category;";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			rs = prstmt.executeQuery();
			while (rs.next()) {
				CategoryBean category = new CategoryBean();
				category.setCategoryName(rs.getString("category_name"));
				category.setBelongTo(rs.getString("belong_to"));
				category.setCreatedAt(rs.getDate("created_at"));
				category.setUpdatedAt(rs.getDate("updated_at"));
				category.setCategoryId(rs.getInt("category_id"));
				categoryList.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return categoryList;
	} 
	//select table_group_project.project_id, table_group_project.project_name,table_group_project.commit_level, table_group_project.project_summery, table_group_project.project_type, table_group_project.created_at,table_group_project.updated_at from (table_user  INNER JOIN(table_group_member INNER JOIN(table_group  INNER JOIN table_group_project ON table_group.group_id = table_group_project.group_id) ON table_group_member.group_id = table_group.group_id) ON table_user.user_id = table_group_member.user_id) WHERE table_user.user_id=?
	public List<CategoryBean> selectCategoryByUserId(int userId){
		startConnection();
		ResultSet rs = null;
		List<CategoryBean> categoryList = new ArrayList<>();
		try {
			String sql = "SELECT table_category.category_name from(((((table_user INNER JOIN table_check_point ON table_user.user_id = table_check_point.user_id) INNER JOIN table_item ON table_check_point.item_id = table_item.item_id) INNER JOIN table_contents ON table_item.contents_id = table_contents.contents_id) INNER JOIN table_sub_category ON table_contents.sub_category_id=table_sub_category.sub_category_id) INNER JOIN table_category ON table_sub_category.category_id=table_category.category_id) WHERE table_user.user_id=? group by table_category.category_name;";
			PreparedStatement pr = conn.prepareStatement(sql);
			int cnt = 1;
			pr.setInt(cnt, userId);
			rs = pr.executeQuery();
			while(rs.next()){
				CategoryBean category = new CategoryBean();
				category.setCategoryName(rs.getString("category_name"));
				categoryList.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return categoryList;
	}

	// 特定のIDに紐づくリストを取得
	// public List<CategoryBean> selectCategoryById(HttpServletRequest request){
	// ResultSet rs = null;
	// List<CategoryBean> categoryList = new ArrayList<>();
	// try{
	// int id = Integer.parseInt(request.getParameter("ID"));
	// String sql = "SELECT * FROM table_category WHERE id=?;";
	// PreparedStatement prstmt = conn.prepareStatement(sql);
	// int cnt =1;
	// prstmt.setInt(cnt++, id);
	// rs = prstmt.executeQuery();
	// while(rs.next()){
	// CategoryBean category = new CategoryBean();
	// category.setCategoryName(rs.getString("category_name"));
	// category.setBelongTo(rs.getString("belong_to"));
	// category.setCreatedAt(rs.getDate("created_at"));
	// category.setUpdatedAt(rs.getDate("updated_at"));
	// categoryList.add(category);
	// }
	// }catch(SQLException e){
	// e.printStackTrace();
	// return categoryList;
	// }
	// return categoryList;
	// }

	// 削除系のメソッド(フラグ管理バージョン)
	public int deleteCategory(HttpServletRequest request) {
		int successNum = 0;
		startConnection();
		try {
			int deleteFlag = Integer.parseInt(request
					.getParameter("DELETE_FLAG"));
			String sql = "UPDATE table_category SET delete_flag=? WHERE category_id=?";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			int ctn = 1;
			prstmt.setInt(ctn++, deleteFlag);
			successNum = prstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return successNum;
	}

	// 編集系のメソッド(一括の編集)
	public int updateCategory(HttpServletRequest request) {
		int successNum = 0;
		startConnection();
		try {
			int categoryId = Integer.parseInt(request
					.getParameter("CATEGORY_ID"));
			String categoryName = request.getParameter("CATEGORY_NAME");
			String belongTo = request.getParameter("BELONG_TO");
			String sql = "UPDATE table_category SET category_name=?, belong_to=? WHERE category_id=?;";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			int ctn = 1;
			prstmt.setString(ctn++, categoryName);
			prstmt.setString(ctn++, belongTo);
			prstmt.setInt(ctn++, categoryId);
			successNum = prstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return successNum;
	}
}
