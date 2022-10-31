package com.kh.semiPrj.community.vo;

import java.sql.Date;

public class CommentVo {

	private int no;
	private int mNo;
	private int commuNo;
	private String content;
	private String nick;
	private Date enrollDate;
	private Date modifyDate;
	private String deleteYn;
	
	public CommentVo() {
		super();
	}

	public CommentVo(int no, int mNo, int commuNo, String content, String nick, Date enrollDate, Date modifyDate,
			String deleteYn) {
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

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public int getCommuNo() {
		return commuNo;
	}

	public void setCommuNo(int commuNo) {
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
