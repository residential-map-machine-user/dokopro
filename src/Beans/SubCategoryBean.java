package Beans;

import java.sql.Timestamp;
import java.util.List;

public class SubCategoryBean {
	private int subCategoryId;
	private String title;
	private Timestamp createdAt;
	private Timestamp updatedAt;
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
