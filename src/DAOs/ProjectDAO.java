package DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import BaseClasses.BaseDAO;
import Beans.ProjectBean;
import Utils.Util;

public class ProjectDAO extends BaseDAO {
	// 必要なメソッド
	// プロジェクトを作成するメソッド
	// プロジェクトを編集するメソッド
	// プロジェクトを削除するメソッド
	// プロジェクトを表示するメソッド

	//プロジェクト作成用のメソッド
	//とりあえずコミットレベル、プロジェクトの説明,プロジェクト名まであれば十分だとして進める.
	public int addProject(String projectName, int commitLevel, String projectSummery, int groupId){
		int successNum = 0;
		startConnection();
		try {
			String sql = "INSERT INTO table_group_project (project_name,project_summery,commit_level, group_id) values(?,?,?,?);";
			PreparedStatement pr = conn.prepareStatement(sql);
			int cnt = 1;
			pr.setString(cnt++, projectName);
			pr.setString(cnt++,projectSummery);
			pr.setInt(cnt++, commitLevel);
			pr.setInt(cnt++, groupId);
			successNum = pr.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return successNum;
	}

	// プロジェクトを全権表示するメソッド
	public List<ProjectBean> selectAllProject(HttpServletRequest request) {
		List<ProjectBean> projectList = new ArrayList<>();
		startConnection();
		try {
			ResultSet rs = null;
			String sql = "SELECT * FROM table_project;";
			PreparedStatement pr = conn.prepareStatement(sql);
			rs = pr.executeQuery();
			while (rs.next()) {
				ProjectBean project = new ProjectBean();
				project.setProjectId(rs.getInt("project_id"));
				project.setCommitLevel(rs.getInt("commit_level"));
				project.setProjectSummery(rs.getString("project_summery"));
				project.setProjectType(rs.getInt("project_type"));
				project.setCreatedAt(rs.getTimestamp("created_at"));
				project.setUpdatedAt(rs.getTimestamp("updated_at"));
				projectList.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return projectList;
	}

	// プロジェクトをgroupIdから取得してくるメソッド
	public List<ProjectBean> selectProjectByGroupId(int groupId) {
		List<ProjectBean> projectList = new ArrayList<>();
		startConnection();
		try {
			ResultSet rs = null;
			String sql = "SELECT * FROM table_group_project WHERE group_id=?;";
			PreparedStatement pr = conn.prepareStatement(sql);
			int cnt = 1;
			pr.setInt(cnt++, groupId);
			rs = pr.executeQuery();
			while (rs.next()) {
				ProjectBean project = new ProjectBean();
				project.setProjectId(rs.getInt("project_id"));
				project.setCommitLevel(rs.getInt("commit_level"));
				project.setProjectSummery(rs.getString("project_summery"));
				project.setProjectType(rs.getInt("project_type"));
//				project.setCreatedAt(rs.getTimestamp("created_at"));
//				project.setUpdatedAt(rs.getTimestamp("updated_at"));
				project.setProjectName(rs.getString("project_name"));
//				project.setDayStart(rs.getTimestamp("day_start"));
//				project.setDayStart(rs.getTimestamp("day_finish"));
				projectList.add(project);
				Util.l("DBプロジェクト>>>>>>"+ rs.getInt("project_id"));
				Util.l("DBプロジェクト>>>>>>"+ rs.getString("project_name"));
				Util.l("DBプロジェクト>>>>>>"+ rs.getString("project_summery"));
				Util.l("DBプロジェクト>>>>>>"+ rs.getInt("commit_level"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return projectList;
	}

	// グループをユーザIDから取得してくる
	public List<ProjectBean> selectProjectByUserId(HttpServletRequest request) {
		List<ProjectBean> projectList = new ArrayList<>();
		startConnection();
		int projectId = Integer.parseInt(request.getParameter("USER_ID"));
		try {
			ResultSet rs = null;
			// [TODO]sqlをuseridから遡っていく

			/**
			 * select group_member_id from table_user WHERE user_id =1 JOIN
			 * table_group_member ON table_user.user_id =
			 * table_group_member.user_id; select * from table_group_member JOIN
			 * table_group ON table_group_member.group_id = table_group.group_id
			 * select * fron table_group JOIN table_project ON
			 * table_group.group_id = table_project.group_Id;
			 * この３つのセレクト文を使えばうまくuser_idからプロジェクト情報を取得してこれるはず
			 */
			String sql = "select table_group_project.project_id, table_group_project.project_name,table_group_project.commit_level, table_group_project.project_summery, table_group_project.project_type, table_group_project.created_at,table_group_project.updated_at from (table_user  INNER JOIN(table_group_member INNER JOIN(table_group  INNER JOIN table_group_project ON table_group.group_id = table_group_project.group_id) ON table_group_member.group_id = table_group.group_id) ON table_user.user_id = table_group_member.user_id) WHERE table_user.user_id=?";
			PreparedStatement pr = conn.prepareStatement(sql);
			int cnt = 1;
			pr.setInt(cnt++, projectId);
			rs = pr.executeQuery();
			while (rs.next()) {
				ProjectBean project = new ProjectBean();
				project.setProjectId(rs.getInt("project_id"));
				project.setCommitLevel(rs.getInt("commit_level"));
				project.setProjectSummery(rs.getString("project_summery"));
				project.setProjectType(rs.getInt("project_type"));
				project.setCreatedAt(rs.getTimestamp("created_at"));
				project.setUpdatedAt(rs.getTimestamp("updated_at"));
				projectList.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return projectList;
	}

	public ProjectBean selectProjectById(int projectId){
		ProjectBean project = new ProjectBean();
		try{
			String sql = "S";
			PreparedStatement pr = conn.prepareStatement(sql);
			int cnt = 1;
			pr.setInt(cnt++, projectId);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return project;
	}
	// プロジェクトの削除メソッド
	public int deleteProject(HttpServletRequest request) {
		int successNum = 0;
		startConnection();
		try {
			int project_id = Integer.parseInt(request
					.getParameter("PROJECT_ID"));
			String sql = "UPDATE table_group_project set delete_flag=1 WHERE project_id=?;";
			PreparedStatement pr = conn.prepareStatement(sql);
			int cnt = 1;
			pr.setInt(cnt++, project_id);
			successNum = pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			finishConnection();
		}
		return successNum;
	}
}
