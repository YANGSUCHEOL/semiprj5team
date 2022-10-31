package com.kh.semiPrj.bqna.vo;

public class BanswerVo {
	
	
	
	public BanswerVo() {
	}
	public BanswerVo(String no, String bNo, String mNo, String content, String enrollDate, String updateDate,
			String deleteYn) {
		this.no = no;
		this.bNo = bNo;
		this.mNo = mNo;
		this.content = content;
		this.enrollDate = enrollDate;
		this.updateDate = updateDate;
		this.deleteYn = deleteYn;
	}
	private String no;
	private String bNo;
	private String mNo;
	private String content;
	private String enrollDate;
	private String updateDate;
	private String deleteYn;
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
	public String getDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}
	@Override
	public String toString() {
		return "BanswerVo [no=" + no + ", bNo=" + bNo + ", mNo=" + mNo + ", content=" + content + ", enrollDate="
				+ enrollDate + ", updateDate=" + updateDate + ", deleteYn=" + deleteYn + "]";
	}
	
	

}
