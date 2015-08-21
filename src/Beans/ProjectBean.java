package Beans;

import java.sql.Timestamp;



public class ProjectBean {
	private int projectId;
	private int commitLevel;
	private String projectSummery;
	private int projectType;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private Timestamp dayStart;
	private Timestamp dayFinish;
	private String projectName;
	public Timestamp getDayStart() {
		return dayStart;
	}
	public void setDayStart(Timestamp dayStart) {
		this.dayStart = dayStart;
	}
	public Timestamp getDayFinish() {
		return dayFinish;
	}
	public void setDayFinish(Timestamp dayFinish) {
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
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
