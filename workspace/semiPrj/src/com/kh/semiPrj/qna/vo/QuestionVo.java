package com.kh.semiPrj.qna.vo;

public class QuestionVo {
	
	
	
	
	
	public QuestionVo() {
		
	}
	public QuestionVo(String no, String mNo, String title, String content, String memcode, String enrollDate,
			String updateDate, String deleteYn) {
		
		this.no = no;
		this.mNo = mNo;
		this.title = title;
		this.content = content;
		this.memcode = memcode;
		this.enrollDate = enrollDate;
		this.updateDate = updateDate;
		this.deleteYn = deleteYn;
	}
	public String no;
	public String mNo;
	public String title;
	public String content;
	public String memcode;
	public String enrollDate;
	public String updateDate;
	public String deleteYn;
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
	public String getMemcode() {
		return memcode;
	}
	public void setMemcode(String memcode) {
		this.memcode = memcode;
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
		return "QuestionVo [no=" + no + ", mNo=" + mNo + ", title=" + title + ", content=" + content + ", memcode="
				+ memcode + ", enrollDate=" + enrollDate + ", updateDate=" + updateDate + ", deleteYn=" + deleteYn
				+ "]";
	}
	
	

}
