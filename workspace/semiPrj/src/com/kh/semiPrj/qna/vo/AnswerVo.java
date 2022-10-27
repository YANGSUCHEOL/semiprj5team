package com.kh.semiPrj.qna.vo;

public class AnswerVo {
	
	
	
	
	public AnswerVo() {
	}
	public AnswerVo(String no, String qNo, String mNo, String content, String enrollDate, String updateDate,
			String deleteYN) {
		this.no = no;
		this.qNo = qNo;
		this.mNo = mNo;
		this.content = content;
		this.enrollDate = enrollDate;
		this.updateDate = updateDate;
		this.deleteYN = deleteYN;
	}
	private String no;
	private String qNo;
	private String mNo;
	private String content;
	private String enrollDate;
	private String updateDate;
	private String deleteYN;
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
	public String getmNo() {
		return mNo;
	}
	public void setmNo(String mNo) {
		this.mNo = mNo;
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
	public String getDeleteYN() {
		return deleteYN;
	}
	public void setDeleteYN(String deleteYN) {
		this.deleteYN = deleteYN;
	}
	@Override
	public String toString() {
		return "AnswerVo [no=" + no + ", qNo=" + qNo + ", mNo=" + mNo + ", content=" + content + ", enrollDate="
				+ enrollDate + ", updateDate=" + updateDate + ", deleteYN=" + deleteYN + "]";
	}
	
	


}
