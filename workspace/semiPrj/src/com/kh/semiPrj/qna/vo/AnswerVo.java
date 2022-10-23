package com.kh.semiPrj.qna.vo;

public class AnswerVo {
	
	
	
	
	public AnswerVo() {
	}
	public AnswerVo(String no, String qNo, String title, String content, String hit, String enrollDate,
			String updateDate, String deleteYn) {
		this.no = no;
		this.qNo = qNo;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.enrollDate = enrollDate;
		this.updateDate = updateDate;
		this.deleteYn = deleteYn;
	}
	public String no;
	public String qNo;
	public String title;
	public String content;
	public String hit;
	public String enrollDate;
	public String updateDate;
	public String deleteYn;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getqNo() {
		return qNo;
	}
	public void setqNo(String qNo) {
		this.qNo = qNo;
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
	public String getDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}
	@Override
	public String toString() {
		return "AnswerVo [no=" + no + ", qNo=" + qNo + ", title=" + title + ", content=" + content + ", hit=" + hit
				+ ", enrollDate=" + enrollDate + ", updateDate=" + updateDate + ", deleteYn=" + deleteYn + "]";
	}
	
	
	
	

}
