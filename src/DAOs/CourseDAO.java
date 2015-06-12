package DAOs;

import BaseClasses.BaseDAO;

public class CourseDAO extends BaseDAO {
	//結局ここのDAOに付いてはほとんどデフォルトで表示しておくものなので最初はallで対応しておく
	
	/**
	 * カテゴリー
	 */
	// 増やす：カテゴリーを作る
	// 表示:カテゴリーを全件表示
	// 編集:カテゴリーを編集する
	// 消す:フラグで管理する
	public CategoryBean CategoryDAO(HttpServletRequest request){
		List<CategoryBean> categoryList = new ArrayList<>();
		
	}
	
	/**
	 * サブカテゴリー
	 */
	// 増やす:サブカテゴリーを作る
	// 表示:サブカテゴリーを全件表示
	// 編集:サブカテゴリーを編集する
	// 消す:フラグで管理する
	/**
	 * コンテンツ
	 */
	// 増やす:サブカテゴリーを作る
	// 表示:サブカテゴリーを全件表示
	// 編集:サブカテゴリーを編集する
	// 消す:フラグで管理する
	/**
	 * アイテム
	 */
	// 増やす:サブカテゴリーを作る
	// 表示:サブカテゴリーを全件表示
	// 編集:サブカテゴリーを編集する
	// 消す:フラグで管理する
	
	//進捗
	//総数を取得するキャッシュさせておく
	//特定のユーザの学習済みの問題取得しておく
//	select count(item_id) from check_point_table where user_id=? AND complete_flag=1;
//			while(rs){}
}
