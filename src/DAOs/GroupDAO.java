package DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import BaseClasses.BaseDAO;
import Beans.GroupBean;

public class GroupDAO extends BaseDAO {
	// グループの作成
	// グループの全権表示
	// グループの削除(削除フラグ)
	// グループの編集
	// グループの表示(selectByUserId)
	// メンバーの表示(selectByGroupId)
	public int addGroup(HttpServletRequest request) {
		int successNum = 0;
		startConnection();
		try {
			String groupName = request.getParameter("GROUP_NAME");
			String description = request.getParameter("GROUP_DESCRIPTION");
			String sql = "INSERT INTO table_group (group_name,description) values(?,?);";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			int ctn = 1;
			prstmt.setString(ctn++, groupName);
			prstmt.setString(ctn++, description);
			successNum = prstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finishConnection();
		}
		return successNum;
	}

	// セレクト系のメソッド
	public List<GroupBean> selectAllGroup() {
		ResultSet rs = null;
		startConnection();
		List<GroupBean> groupList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM table_group;";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			rs = prstmt.executeQuery();
			while (rs.next()) {
				GroupBean group = new GroupBean();
				group.setGroupName(rs.getString("group_name"));
				group.setGroupId(rs.getInt("group_id"));
				group.setDeleteFlag(rs.getInt("delete_flag"));
				group.setCreatedAt(rs.getDate("created_at"));
				group.setUpdatedAt(rs.getDate("updated_at"));
				group.setDescription(rs.getString("description"));
				groupList.add(group);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return groupList;
	}

	// 特定のIDに紐づくリストを取得
	public GroupBean selectGroupByGroupId(int groupId) {
		ResultSet rs = null;
		startConnection();
		GroupBean group = new GroupBean();
		try {
			int cnt = 1;
			String sql = "SELECT * FROM table_group WHERE group_id=?;";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			prstmt.setInt(cnt++, groupId);
			rs = prstmt.executeQuery();
			while (rs.next()) {
				group.setGroupName(rs.getString("group_name"));
				group.setGroupId(rs.getInt("group_id"));
				group.setDeleteFlag(rs.getInt("delete_flag"));
				group.setCreatedAt(rs.getDate("created_at"));
				group.setUpdatedAt(rs.getDate("updated_at"));
				group.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return group;
	}

	// 削除系のメソッド(フラグ管理バージョン)
	public int deleteGroup(HttpServletRequest request){
		  int successNum = 0;
		  try{
		    int deleteFlag = Integer.parseInt(request.getParameter("DELETE_FLAG"));
		    String sql = "UPDATE table_ SET delete_flag=? WHERE group_id=?;";
		    PreparedStatement prstmt = conn.prepareStatement(sql);
		    int ctn = 1;
		    prstmt.setInt(ctn++, deleteFlag);
		    successNum = prstmt.executeUpdate();
		  }catch(SQLException e){
		    e.printStackTrace();
		    return successNum;
		  }
		  return successNum;
		}

	// 編集系のメソッド(一括の編集)
	public int updateGroup(HttpServletRequest request) {
		int successNum = 0;
		try {
			int group_id = Integer
					.parseInt(request.getParameter("CATEGORY_ID"));
			String groupName = request.getParameter("GROUP_NAME");
			String groupAddress = request.getParameter("GROUP_ADDRESS");
			String groupNickname = request.getParameter("GROUP_NICKNAME");
			String sql = "UPDATE table_ SET group_name=?, group_address=?, group_nickname=? WHERE group_id=?;";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			int ctn = 1;
			prstmt.setString(ctn++, groupName);
			prstmt.setString(ctn++, groupAddress);
			prstmt.setString(ctn++, groupNickname);
			successNum = prstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return successNum;
		}
		return successNum;
	}
}
