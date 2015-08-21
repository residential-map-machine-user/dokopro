package DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BaseClasses.BaseDAO;
import Beans.ProgressBean;

public class ProgressDAO extends BaseDAO {

	public Map<Integer,ProgressBean> selectContentsProgress(int userId,int categoryId) {
		int progressCount = 0;
		Map<Integer,ProgressBean> progressMap = new HashMap<Integer, ProgressBean>();
		try {
			startConnection();
			ResultSet rs = null;
			String sql = "select table_contents.contents_title, table_contents.contents_id, SUM(table_check_point.complete_flag) AS complete_count from (((((table_user JOIN table_check_point on table_user.user_id=table_check_point.user_id) JOIN table_item ON table_check_point.item_id=table_item.item_id) JOIN table_contents ON table_item.contents_id=table_contents.contents_id) JOIN table_sub_category ON table_contents.sub_category_id=table_sub_category.sub_category_id ) JOIN table_category ON table_category.category_id=table_sub_category.category_id) where table_user.user_id=? AND table_check_point.complete_flag=1 AND table_category.category_id=? group by table_contents.contents_id;";
			PreparedStatement pr = conn.prepareStatement(sql);
			int cnt = 1;
			pr.setInt(cnt++, userId);
			pr.setInt(cnt++, categoryId);
			rs  =pr.executeQuery();
			while(rs.next()){
				ProgressBean progress = new ProgressBean();
				int contentsId = rs.getInt("contents_id");
				progress.setContentsId(contentsId);
				progress.setCompleteCount(rs.getInt("complete_count"));
				progress.setContentsTitle(rs.getString("contents_title"));
//				progressList.add(progress);
				progressMap.put(contentsId, progress);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return progressMap;
	}
	
	public Map<Integer, Integer> selectQuestionCount(int categoryId){
		Map<Integer, Integer> questionCountMap = new HashMap<Integer,Integer>();
		try{
			ResultSet rs = null;
			String sql = "select COUNT( table_item.item_id) AS question_count, table_contents.contents_id FROM (((table_item join table_contents on table_item.contents_id=table_contents.contents_id) join table_sub_category on table_contents.sub_category_id=table_sub_category.sub_category_id) join table_category on table_category.category_id=table_sub_category.category_id) WHERE table_category.category_id=? group by table_contents.contents_id;";
			PreparedStatement pr  = conn.prepareStatement(sql);
			int cnt = 1;
			pr.setInt(cnt++, categoryId);
			rs = pr.executeQuery();
			while(rs.next()){
				int contentsId = rs.getInt("contents_id");
				int questionCount = rs.getInt("question_count");
				questionCountMap.put(contentsId, questionCount);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return questionCountMap;
	}
	
}
