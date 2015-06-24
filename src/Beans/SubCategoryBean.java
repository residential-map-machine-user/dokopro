package Beans;

import java.sql.Date;
import java.util.List;

public class SubCategoryBean {
	private int subCategoryId;
	private String title;
	private Date createdAt;
	private Date updatedAt;
	private List<ContentsBean> contentsList;
	public List<ContentsBean> getContentsList() {
		return contentsList;
	}
	public void setContentsList(List<ContentsBean> contentsList) {
		this.contentsList = contentsList;
	}
	public int getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
