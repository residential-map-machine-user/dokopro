package DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import BaseClasses.BaseDAO;
import Beans.SubCategoryBean;

public class SubCategoryDAO extends BaseDAO {
	/**
	 * サブカテゴリー
	 */
	// 増やす:サブカテゴリーを作る
	// 表示:サブカテゴリーを全件表示
	// 編集:サブカテゴリーを編集する
	// 消す:フラグで管理する
	// 追加系のメソッド
	public int addSubCategory(HttpServletRequest request) {
		int successNum = 0;
		startConnection();
		try {
			String title = request.getParameter("TITLE");
			String sql = "INSERT INTO table_sub_category (title) values(?);";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			int ctn = 1;
			prstmt.setString(ctn++, title);
			successNum = prstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return successNum;
	}

	// セレクト系のメソッド
	public List<SubCategoryBean> selectAllSubCategory(HttpServletRequest request) {
		ResultSet rs = null;
		startConnection();
		List<SubCategoryBean> subCategoryList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM table_sub_category;";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			rs = prstmt.executeQuery();
			while (rs.next()) {
				SubCategoryBean subCategory = new SubCategoryBean();
				subCategory.setTitle(rs.getString("title"));
				subCategory.setCreatedAt(rs.getDate("created_at"));
				subCategory.setUpdatedAt(rs.getDate("updated_at"));
				subCategoryList.add(subCategory);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return subCategoryList;
	}

	// 特定のIDに紐づくリストを取得
	public List<SubCategoryBean> selectSubCategoryByCategoryId(int categoryId) {
		ResultSet rs = null;
		startConnection();
		List<SubCategoryBean> subCategoryList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM table_sub_category WHERE category_id=?;";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			int cnt = 1;
			prstmt.setInt(cnt++, categoryId);
			rs = prstmt.executeQuery();
			while (rs.next()) {
				SubCategoryBean subCategory = new SubCategoryBean();
				subCategory.setTitle(rs.getString("title"));
				subCategory.setSubCategoryId(rs.getInt("sub_category_id"));
//				subCategory.setCreatedAt(rs.getTimestamp("created_at"));
//				subCategory.setUpdatedAt(rs.getTimestamp("updated_at"));
				subCategoryList.add(subCategory);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return subCategoryList;
	}

	// 削除系のメソッド(フラグ管理バージョン)
	public int deleteSubCategory(HttpServletRequest request) {
		int successNum = 0;
		startConnection();
		try {
			int deleteFlag = Integer.parseInt(request
					.getParameter("DELETE_FLAG"));
			String sql = "UPDATE table_sub_category SET delete_flag=? WHERE sub_category_id=?";
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
	public int updateSubCategory(HttpServletRequest request) {
		int successNum = 0;
		startConnection();
		try {
			int subCategoryId = Integer.parseInt(request
					.getParameter("SUB_CATEGORY_ID"));
			String title = request.getParameter("TITLE");
			String sql = "UPDATE table_sub_category SET title=? WHERE sub_category_id=?;";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			int ctn = 1;
			prstmt.setString(ctn++, title);
			;
			prstmt.setInt(ctn++, subCategoryId);
			successNum = prstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return successNum;
	}

}
