package Beans;

import java.sql.Date;

public class GroupBean {
private int groupId;
private int deleteFlag;
private String groupName;
private Date createdAt;
private Date updatedAt;
public int getGroupId() {
	return groupId;
}
public void setGroupId(int groupId) {
	this.groupId = groupId;
}
public int getDeleteFlag() {
	return deleteFlag;
}
public void setDeleteFlag(int deleteFlag) {
	this.deleteFlag = deleteFlag;
}
public String getGroupName() {
	return groupName;
}
public void setGroupName(String groupName) {
	this.groupName = groupName;
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
}
