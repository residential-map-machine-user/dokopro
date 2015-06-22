package DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import BaseClasses.BaseDAO;
import Beans.CategoryBean;
import Beans.ContentsBean;
import Beans.ItemBean;
import Beans.SubCategoryBean;

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
		}
		return successNum;
	}

	// セレクト系のメソッド
	public List<CategoryBean> selectAllCategory(HttpServletRequest request) {
		ResultSet rs = null;
		List<CategoryBean> categoryList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM table_category;";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			rs = prstmt.executeQuery();
			while (rs.next()) {
				CategoryBean category = new CategoryBean();
				category.setCategoryName(rs.getString("category_name"));
				category.setBelongTo(rs.getString("belong_to"));
				category.setCreatedAt(rs.getDate("created_at"));
				category.setUpdatedAt(rs.getDate("updated_at"));
				categoryList.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return categoryList;
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
			return successNum;
		}
		return successNum;
	}

	// 編集系のメソッド(一括の編集)
	public int updateCategory(HttpServletRequest request) {
		int successNum = 0;
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
			return successNum;
		}
		return successNum;
	}

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
		try {
			String title = request.getParameter("TITLE");
			String sql = "INSERT INTO table_sub_category (title) values(?);";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			int ctn = 1;
			prstmt.setString(ctn++, title);
			successNum = prstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return successNum;
	}

	// セレクト系のメソッド
	public List<SubCategoryBean> selectAllSubCategory(HttpServletRequest request) {
		ResultSet rs = null;
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
			return subCategoryList;
		}
		return subCategoryList;
	}

	// 特定のIDに紐づくリストを取得
	public List<SubCategoryBean> selectSubCategoryByCategoryId(
			HttpServletRequest request) {
		ResultSet rs = null;
		List<SubCategoryBean> subCategoryList = new ArrayList<>();
		try {
			int categoryId = Integer.parseInt(request
					.getParameter("CATEGORY_ID"));
			String sql = "SELECT * FROM table_sub_category WHERE category_id=?;";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			int cnt = 1;
			prstmt.setInt(cnt++, categoryId);
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
			return subCategoryList;
		}
		return subCategoryList;
	}

	// 削除系のメソッド(フラグ管理バージョン)
	public int deleteSubCategory(HttpServletRequest request) {
		int successNum = 0;
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
			return successNum;
		}
		return successNum;
	}

	// 編集系のメソッド(一括の編集)
	public int updateSubCategory(HttpServletRequest request) {
		int successNum = 0;
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
			return successNum;
		}
		return successNum;
	}

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
		try {
			String contentsTitle = request.getParameter("CONTENTS_TITLE");
			String sql = "INSERT INTO table_contents (contents_title) values(?);";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			int ctn = 1;
			prstmt.setString(ctn++, contentsTitle);
			successNum = prstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return successNum;
	}

	// セレクト系のメソッド
	public List<ContentsBean> selectAllContents(HttpServletRequest request) {
		ResultSet rs = null;
		List<ContentsBean> contentsList = new ArrayList<>();
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
			return contentsList;
		}
		return contentsList;
	}

	// 特定のIDに紐づくリストを取得
	public List<ContentsBean> selectContentsBySubCategoryId(
			HttpServletRequest request) {
		ResultSet rs = null;
		List<ContentsBean> contentsList = new ArrayList<>();
		try {
			int subCategoryId = Integer.parseInt(request
					.getParameter("SUB_CATEGORY_ID"));
			String sql = "SELECT * FROM table_contents WHERE category_id=?;";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			int cnt = 1;
			prstmt.setInt(cnt++, subCategoryId);
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
			return contentsList;
		}
		return contentsList;
	}

	// 削除系のメソッド(フラグ管理バージョン)
	public int deleteContents(HttpServletRequest request) {
		int successNum = 0;
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
			return successNum;
		}
		return successNum;
	}

	// 編集系のメソッド(一括の編集)
	public int updateContents(HttpServletRequest request) {
		int successNum = 0;
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
			return successNum;
		}
		return successNum;
	}

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
		}
		return successNum;
	}

	// セレクト系のメソッド
	public List<ItemBean> selectItem(HttpServletRequest request) {
		ResultSet rs = null;
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
			return itemList;
		}
		return itemList;
	}

	// 特定のIDに紐づくリストを取得
	public List<ItemBean> selectItemByContentsId(
			HttpServletRequest request) {
		ResultSet rs = null;
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
			return itemList;
		}
		return itemList;
	}

	// 削除系のメソッド(フラグ管理バージョン)
	public int deleteItem(HttpServletRequest request) {
		int successNum = 0;
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
			return successNum;
		}
		return successNum;
	}

	// 編集系のメソッド(一括の編集)
	public int updateItem(HttpServletRequest request) {
		int successNum = 0;
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
			return successNum;
		}
		return successNum;
	}

}
