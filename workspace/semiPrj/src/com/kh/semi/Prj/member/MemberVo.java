package com.kh.semi.Prj.member;

public class MemberVo {
	
	private String no;
	private String gradeNo;
	private String nick;
	private String id;
	private String pwd;
	private String birth;
	private String name;
	private String phone;
	private String quitYn;
	private String enrollDate;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getGradeNo() {
		return gradeNo;
	}
	public void setGradeNo(String gradeNo) {
		this.gradeNo = gradeNo;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
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
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
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
		return "MemberVo [no=" + no + ", gradeNo=" + gradeNo + ", nick=" + nick + ", id=" + id + ", pwd=" + pwd
				+ ", birth=" + birth + ", name=" + name + ", phone=" + phone + ", quitYn=" + quitYn + ", enrollDate="
				+ enrollDate + "]";
	}
	public MemberVo(String no, String gradeNo, String nick, String id, String pwd, String birth, String name,
			String phone, String quitYn, String enrollDate) {
		super();
		this.no = no;
		this.gradeNo = gradeNo;
		this.nick = nick;
		this.id = id;
		this.pwd = pwd;
		this.birth = birth;
		this.name = name;
		this.phone = phone;
		this.quitYn = quitYn;
		this.enrollDate = enrollDate;
	}
	
	public MemberVo() {
		
	}
	

}
