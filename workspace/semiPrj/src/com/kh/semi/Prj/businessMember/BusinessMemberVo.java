package com.kh.semi.Prj.businessMember;

public class BusinessMemberVo {

	private String no;
	private String rNo;
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String nick;
	private String bNum;
	private String quitYn;
	private String enrollDate;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getrNo() {
		return rNo;
	}
	public void setrNo(String rNo) {
		this.rNo = rNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getbNum() {
		return bNum;
	}
	public void setbNum(String bNum) {
		this.bNum = bNum;
	}
	public String getQuitYn() {
		return quitYn;
	}
	public void setQuitYn(String quitYn) {
		this.quitYn = quitYn;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	@Override
	public String toString() {
		return "BusinessMemberVo [no=" + no + ", rNo=" + rNo + ", id=" + id + ", pwd=" + pwd + ", name=" + name
				+ ", phone=" + phone + ", nick=" + nick + ", bNum=" + bNum + ", quitYn=" + quitYn + ", enrollDate="
				+ enrollDate + "]";
	}
	public BusinessMemberVo(String no, String rNo, String id, String pwd, String name, String phone, String nick,
			String bNum, String quitYn, String enrollDate) {
		super();
		this.no = no;
		this.rNo = rNo;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.nick = nick;
		this.bNum = bNum;
		this.quitYn = quitYn;
		this.enrollDate = enrollDate;
	}
	
	public BusinessMemberVo() {
		
	}

}
