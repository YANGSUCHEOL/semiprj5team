package com.kh.semiPrj.coupon;

public class CouponVo {
	
	private String no;
	private String rNo;
	private String cNo;
	private String rName;
	private String info;
	
	public CouponVo(String no, String rNo, String cNo, String rName, String info) {
		super();
		this.no = no;
		this.rNo = rNo;
		this.cNo = cNo;
		this.rName = rName;
		this.info = info;
	}
	public CouponVo() {
		super();
	}
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
	public String getcNo() {
		return cNo;
	}
	public void setcNo(String cNo) {
		this.cNo = cNo;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "CouponVo [no=" + no + ", rNo=" + rNo + ", cNo=" + cNo + ", rName=" + rName + ", info=" + info + "]";
	}
	
}
