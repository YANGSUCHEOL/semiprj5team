package com.kh.semiPrj.bqna.vo;

public class BquestionVo {

	
	
	
	public BquestionVo() {
	}
	public BquestionVo(String no, String bNo, String title, String content, String hit, String enrollDate,
			String updateDate, String deleteYn, String answerYn) {
		this.no = no;
		this.bNo = bNo;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.enrollDate = enrollDate;
		this.updateDate = updateDate;
		this.deleteYn = deleteYn;
		this.answerYn = answerYn;
	}
	private String no;
	private String bNo;
	private String title;
	private String content;
	private String hit;
	private String enrollDate;
	private String updateDate;
	private String deleteYn;
	private String answerYn;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getbNo() {
		return bNo;
	}
	public void setbNo(String bNo) {
		this.bNo = bNo;
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
	public String getAnswerYn() {
		return answerYn;
	}
	public void setAnswerYn(String answerYn) {
		this.answerYn = answerYn;
	}
	@Override
	public String toString() {
		return "BquestionVo [no=" + no + ", bNo=" + bNo + ", title=" + title + ", content=" + content + ", hit=" + hit
				+ ", enrollDate=" + enrollDate + ", updateDate=" + updateDate + ", deleteYn=" + deleteYn + ", answerYn="
				+ answerYn + "]";
	}

	
}
