package Beans;

import java.sql.Timestamp;


public class UserBean {
	private int userId;
	private String accountName;
	private String mail;
	private String password;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private int authFlag;
	private int userTypes;
	private int deleteFlag;
	public int getDeleteFlag(){
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag){
		this.deleteFlag = deleteFlag;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public int getAuthFlag() {
		return authFlag;
	}
	public void setAuthFlag(int authFlag) {
		this.authFlag = authFlag;
	}
	public int getUserTypes() {
		return userTypes;
	}
	public void setUserTypes(int userTypes) {
		this.userTypes = userTypes;
	}
}
