package com.kh.semiPrj.community.vo;

public class CommuVo {
	
	public CommuVo() {

	
	}
		
	public CommuVo(String no, String mNo, String cNo, String category, String type, String title, String content,
			String writer, String hit, String enrollDate, String updateDate, String status) {
		this.no = no;
		this.mNo = mNo;
		this.cNo = cNo;
		this.category = category;
		this.type = type;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.hit = hit;
		this.enrollDate = enrollDate;
		this.updateDate = updateDate;
		this.status = status;
	}


	private String no;
	private String mNo;
	private String cNo;
	private String category;
	private String type;
	private String title;
	private String content;
	private String writer;
	private String hit;
	private String enrollDate;
	private String updateDate;
	private String status;
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getmNo() {
		return mNo;
	}

	public void setmNo(String mNo) {
		this.mNo = mNo;
	}

	public String getcNo() {
		return cNo;
	}

	public void setcNo(String cNo) {
		this.cNo = cNo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CommuVo [no=" + no + ", mNo=" + mNo + ", cNo=" + cNo + ", category=" + category + ", type=" + type
				+ ", title=" + title + ", content=" + content + ", writer=" + writer + ", hit=" + hit + ", enrollDate="
				+ enrollDate + ", updateDate=" + updateDate + ", status=" + status + "]";
	}
	
	
	
	
	
}
