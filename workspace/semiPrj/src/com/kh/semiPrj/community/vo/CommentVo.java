package com.kh.semiPrj.community.vo;

import java.sql.Date;

public class CommentVo {

	private String no;
	private String mNo;
	private String commuNo;
	private String content;
	private String nick;
	private Date enrollDate;
	private Date modifyDate;
	private String deleteYn;
	
	public CommentVo() {
		super();
	}

	public CommentVo(String no, String mNo, String commuNo, String content, String nick, Date enrollDate,
			Date modifyDate, String deleteYn) {
		super();
		this.no = no;
		this.mNo = mNo;
		this.commuNo = commuNo;
		this.content = content;
		this.nick = nick;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.deleteYn = deleteYn;
	}

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

	public String getCommuNo() {
		return commuNo;
	}

	public void setCommuNo(String commuNo) {
		this.commuNo = commuNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	@Override
	public String toString() {
		return "CommentVo [no=" + no + ", mNo=" + mNo + ", commuNo=" + commuNo + ", content=" + content + ", nick="
				+ nick + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", deleteYn=" + deleteYn + "]";
	}

	
	
	
	
	
	
}
