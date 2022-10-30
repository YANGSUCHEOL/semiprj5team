package com.kh.semiPrj.coupon.history;

public class CouponHistoryVo {
	
	private String no;
	private String rNo;
	private String cNo;
	private String mNo;
	private String usedYn;
	private String enrollDate;
	public CouponHistoryVo(String no, String rNo, String cNo, String mNo, String usedYn, String enrollDate) {
		super();
		this.no = no;
		this.rNo = rNo;
		this.cNo = cNo;
		this.mNo = mNo;
		this.usedYn = usedYn;
		this.enrollDate = enrollDate;
	}
	public CouponHistoryVo() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getmNo() {
		return mNo;
	}
	public void setmNo(String mNo) {
		this.mNo = mNo;
	}
	public String getUsedYn() {
		return usedYn;
	}
	public void setUsedYn(String usedYn) {
		this.usedYn = usedYn;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	@Override
	public String toString() {
		return "CouponHistoryVo [no=" + no + ", rNo=" + rNo + ", cNo=" + cNo + ", mNo=" + mNo + ", usedYn=" + usedYn
				+ ", enrollDate=" + enrollDate + "]";
	}
	

}
