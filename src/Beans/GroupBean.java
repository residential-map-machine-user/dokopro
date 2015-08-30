package Beans;

import java.sql.Timestamp;

public class GroupBean {
private int groupId;
private int deleteFlag;
private String groupName;
private Timestamp createdAt;
private Timestamp updatedAt;
private String description;
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
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
}
