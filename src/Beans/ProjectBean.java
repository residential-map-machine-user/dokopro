package Beans;

import java.sql.Date;

public class ProjectBean {
	private int projectId;
	private int commitLevel;
	private String projectSummery;
	private int projectType;
	private Date createdAt;
	private Date updatedAt;
	private Date dayStart;
	private Date dayFinish;
	private String projectName;
	public Date getDayStart() {
		return dayStart;
	}
	public void setDayStart(Date dayStart) {
		this.dayStart = dayStart;
	}
	public Date getDayFinish() {
		return dayFinish;
	}
	public void setDayFinish(Date dayFinish) {
		this.dayFinish = dayFinish;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getCommitLevel() {
		return commitLevel;
	}
	public void setCommitLevel(int commitLevel) {
		this.commitLevel = commitLevel;
	}
	public String getProjectSummery() {
		return projectSummery;
	}
	public void setProjectSummery(String projectSummery) {
		this.projectSummery = projectSummery;
	}
	public int getProjectType() {
		return projectType;
	}
	public void setProjectType(int projectType) {
		this.projectType = projectType;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
