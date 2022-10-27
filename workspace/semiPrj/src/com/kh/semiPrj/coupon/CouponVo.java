package com.kh.semiPrj.coupon;

public class CouponVo {
	
	@Override
	public String toString() {
		return "CouponVo [no=" + no + ", rNo=" + rNo + ", cNo=" + cNo + ", info=" + info + "]";
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
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public CouponVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CouponVo(String no, String rNo, String cNo, String info) {
		super();
		this.no = no;
		this.rNo = rNo;
		this.cNo = cNo;
		this.info = info;
	}
	private String no;
	private String rNo;
	private String cNo;
	private String info;
}
