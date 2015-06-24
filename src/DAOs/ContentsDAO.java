package DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import BaseClasses.BaseDAO;
import Beans.ContentsBean;

public class ContentsDAO extends BaseDAO{

	/**
	 * コンテンツ
	 */
	// 増やす:サブカテゴリーを作る
	// 表示:サブカテゴリーを全件表示
	// 編集:サブカテゴリーを編集する
	// 消す:フラグで管理する

	// 追加系のメソッド
	public int addContents(HttpServletRequest request) {
		int successNum = 0;
		startConnection();
		try {
			String contentsTitle = request.getParameter("CONTENTS_TITLE");
			String sql = "INSERT INTO table_contents (contents_title) values(?);";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			int ctn = 1;
			prstmt.setString(ctn++, contentsTitle);
			successNum = prstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return successNum;
	}

	// セレクト系のメソッド
	public List<ContentsBean> selectAllContents(HttpServletRequest request) {
		ResultSet rs = null;
		List<ContentsBean> contentsList = new ArrayList<>();
		startConnection();
		try {
			String sql = "SELECT * FROM table_contents;";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			rs = prstmt.executeQuery();
			while (rs.next()) {
				ContentsBean contents = new ContentsBean();
				contents.setContentsTitle(rs.getString("contents_title"));
				contents.setCreatedAt(rs.getDate("created_at"));
				contents.setUpdatedAt(rs.getDate("updated_at"));
				contentsList.add(contents);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return contentsList;
	}

	// 特定のIDに紐づくリストを取得
	public List<ContentsBean> selectContentsBySubCategoryId(int subCategoryId) {
		ResultSet rs = null;
		List<ContentsBean> contentsList = new ArrayList<>();
		startConnection();
		try {
			String sql = "SELECT * FROM table_contents WHERE sub_category_id=?;";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			int cnt = 1;
			prstmt.setInt(cnt++, subCategoryId);
			rs = prstmt.executeQuery();
			while (rs.next()) {
				ContentsBean contents = new ContentsBean();
				contents.setContentsTitle(rs.getString("contents_title"));
				contents.setContentsId(rs.getInt("contents_id"));
//				contents.setCreatedAt(rs.getDate("created_at"));
//				contents.setUpdatedAt(rs.getDate("updated_at"));
				contentsList.add(contents);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return contentsList;
	}

	// 削除系のメソッド(フラグ管理バージョン)
	public int deleteContents(HttpServletRequest request) {
		int successNum = 0;
		startConnection();
		try {
			int deleteFlag = Integer.parseInt(request
					.getParameter("DELETE_FLAG"));
			String sql = "UPDATE table_contents SET delete_flag=? WHERE contents_id=?";
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
	public int updateContents(HttpServletRequest request) {
		int successNum = 0;
		startConnection();
		try {
			int contentsId = Integer.parseInt(request
					.getParameter("CONTENTS_ID"));
			String contentsTitle = request.getParameter("CONTENTS_TITLE");
			String sql = "UPDATE table_contents SET contents_title=? WHERE contents_id=?;";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			int ctn = 1;
			prstmt.setString(ctn++, contentsTitle);
			;
			prstmt.setInt(ctn++, contentsId);
			successNum = prstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return successNum;
	}
}
