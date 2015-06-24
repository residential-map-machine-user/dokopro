package DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import BaseClasses.BaseDAO;
import Beans.ItemBean;

public class ItemDAO extends BaseDAO{


	/**
	 * アイテム
	 */
	// 増やす:サブカテゴリーを作る
	// 表示:サブカテゴリーを全件表示
	// 編集:サブカテゴリーを編集する
	// 消す:フラグで管理する

	// 進捗
	// 総数を取得するキャッシュさせておく
	// 特定のユーザの学習済みの問題取得しておく
	// select count(item_id) from check_point_table where user_id=? AND
	// complete_flag=1;
	// while(rs){}
	// 追加系のメソッド
	public int addItem(HttpServletRequest request) {
		int successNum = 0;
		startConnection();
		try {
			String[] images = request.getParameterValues("IMAGES");
			String bufferSqlForImages = "";
			String bufferSqlForQuestionSymbol = "";
			if (images != null) {
				for (int i = 1; i <= images.length; i++) {
					bufferSqlForImages += ",image" + i;
					bufferSqlForQuestionSymbol += ",?";
				}
			}
			String itemTitle = request.getParameter("ITEM_TITLE");
			String itemText = request.getParameter("ITEM_TEXT");
			String sql = "INSERT INTO table_item (item_title, item_text"
					+ bufferSqlForImages + ") values(?, ?" + bufferSqlForQuestionSymbol+ ");";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			int ctn = 1;
			prstmt.setString(ctn++, itemTitle);
			prstmt.setString(ctn++, itemText);
			for(int i = 1; i <= images.length; i++){
				prstmt.setString(ctn++, images[i-1]);
			}
			successNum = prstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return successNum;
	}

	// セレクト系のメソッド
	public List<ItemBean> selectItem(HttpServletRequest request) {
		ResultSet rs = null;
		startConnection();
		List<ItemBean> itemList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM table_item;";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			rs = prstmt.executeQuery();
			while (rs.next()) {
				ItemBean item = new ItemBean();
				item.setItemTitle(rs.getString("item_title"));
				item.setItemText(rs.getString("item_text"));
				item.setCreatedAt(rs.getDate("created_at"));
				item.setUpdatedAt(rs.getDate("updated_at"));
				itemList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return itemList;
	}

	// 特定のIDに紐づくリストを取得
	public List<ItemBean> selectItemByContentsId(
			HttpServletRequest request) {
		ResultSet rs = null;
		startConnection();
		List<ItemBean> itemList = new ArrayList<>();
		try {
			int contentsId = Integer.parseInt(request
					.getParameter("CONTENTS_ID"));
			String sql = "SELECT * FROM table_item WHERE contents_id=?;";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			int ctn = 1;
			prstmt.setInt(ctn++, contentsId);
			rs = prstmt.executeQuery();
			while (rs.next()) {
				ItemBean item = new ItemBean();
				item.setItemTitle(rs.getString("item_title"));
				item.setItemText(rs.getString("item_text"));
				item.setCreatedAt(rs.getDate("created_at"));
				item.setUpdatedAt(rs.getDate("updated_at"));
				itemList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return itemList;
	}

	// 削除系のメソッド(フラグ管理バージョン)
	public int deleteItem(HttpServletRequest request) {
		int successNum = 0;
		startConnection();
		try {
			int deleteFlag = Integer.parseInt(request
					.getParameter("DELETE_FLAG"));
			String sql = "UPDATE table_item SET delete_flag=? WHERE item_id=?";
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
	public int updateItem(HttpServletRequest request) {
		int successNum = 0;
		startConnection();
		try {
			int itemId = Integer.parseInt(request
					.getParameter("ITEM_ID"));
			String itemTitle = request.getParameter("ITEM_TITLE");
			String itemText = request.getParameter("ITEM_TEXT");
			String image1 = request.getParameter("IMAGE1");
			String image2 = request.getParameter("IMAGE2");
			String image3 = request.getParameter("IMAGE3");
			String sql = "UPDATE table_item SET item_title=?, item_text=?, iamge1=?, image2=?, image3=? WHERE item_id=?;";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			int ctn = 1;
			prstmt.setString(ctn++, itemTitle);
			prstmt.setString(ctn++,itemText);
			prstmt.setString(ctn++, image1);
			prstmt.setString(ctn++, image2);
			prstmt.setString(ctn++, image3);
			prstmt.setInt(ctn++, itemId);
			successNum = prstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return successNum;
	}
}