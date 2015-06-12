package DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import BaseClasses.BaseDAO;
import Beans.ProjectBean;

public class ProjectDAO extends BaseDAO {
	// 必要なメソッド
	// プロジェクトを作成するメソッド
	// プロジェクトを編集するメソッド
	// プロジェクトを削除するメソッド
	// プロジェクトを表示するメソッド

	// プロジェクトを全権表示するメソッド
	public List<ProjectBean> selectAllProject(HttpServletRequest request) {
		List<ProjectBean> projectList = new ArrayList<>();
		try {
			ResultSet rs = null;
			String sql = "SELECT * FROM table_project;";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			rs = prstmt.executeQuery();
			while (rs.next()) {
				ProjectBean project = new ProjectBean();
				project.setProjectId(rs.getInt("project_id"));
				project.setCommitLevel(rs.getInt("commit_level"));
				project.setProjectSummery(rs.getString("project_summery"));
				project.setProjectType(rs.getInt("project_type"));
				project.setCreatedAt(rs.getDate("created_at"));
				project.setUpdatedAt(rs.getDate("updated_at"));
				projectList.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projectList;
	}

	// プロジェクトをgroupIdから取得してくるメソッド
	public List<ProjectBean> selectProjectByGroupId(HttpServletRequest request) {
		List<ProjectBean> projectList = new ArrayList<>();
		int projectId = Integer.parseInt(request.getParameter("PROJECT_ID"));
		try{
			ResultSet rs = null;
			String sql = "SELECT * FROM table_project WHERE project_id=?;";
			PreparedStatement prstmt = conn.prepareStatement(sql);
			int incrementalSymbol = 1;
			prstmt.setInt(incrementalSymbol++, projectId);
			rs = prstmt.executeQuery();
			while (rs.next()) {
				ProjectBean project = new ProjectBean();
				project.setProjectId(rs.getInt("project_id"));
				project.setCommitLevel(rs.getInt("commit_level"));
				project.setProjectSummery(rs.getString("project_summery"));
				project.setProjectType(rs.getInt("project_type"));
				project.setCreatedAt(rs.getDate("created_at"));
				project.setUpdatedAt(rs.getDate("updated_at"));
				projectList.add(project);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return projectList;
	}
	
	//グループをユーザIDから取得してくる
}
