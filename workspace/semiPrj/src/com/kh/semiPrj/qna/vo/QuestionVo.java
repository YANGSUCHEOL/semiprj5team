package com.kh.semiPrj.qna.vo;

public class QuestionVo {
	
	
	
	
	
	public QuestionVo() {
	}
	public QuestionVo(String no, String mNo, String title, String content, String enrollDate, String updateDate,
			String deleteYn, String answerYn) {
		this.no = no;
		this.mNo = mNo;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.updateDate = updateDate;
		this.deleteYn = deleteYn;
		this.answerYn = answerYn;
	}
	private String no;
	private String mNo;
	private String title;
	private String content;
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
	public String getmNo() {
		return mNo;
	}
	public void setmNo(String mNo) {
		this.mNo = mNo;
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
		return "QuestionVo [no=" + no + ", mNo=" + mNo + ", title=" + title + ", content=" + content + ", enrollDate="
				+ enrollDate + ", updateDate=" + updateDate + ", deleteYn=" + deleteYn + ", answerYn=" + answerYn + "]";
	}
	
	
	
	
	

}
