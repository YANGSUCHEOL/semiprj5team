package com.kh.semiPrj.coupon.history;

public class CouponHistoryVo {
	
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getCouNo() {
		return couNo;
	}
	public void setCouNo(String couNo) {
		this.couNo = couNo;
	}
	public String getmNo() {
		return mNo;
	}
	public void setmNo(String mNo) {
		this.mNo = mNo;
	}
	public String getrNo() {
		return rNo;
	}
	public void setrNo(String rNo) {
		this.rNo = rNo;
	}
	public String getUsedYn() {
		return usedYn;
	}
	public void setUsedYn(String usedYn) {
		this.usedYn = usedYn;
	}
	public String getUsedDate() {
		return usedDate;
	}
	public void setUsedDate(String usedDate) {
		this.usedDate = usedDate;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public CouponHistoryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CouponHistoryVo(String no, String couNo, String mNo, String rNo, String usedYn, String usedDate,
			String rName) {
		super();
		this.no = no;
		this.couNo = couNo;
		this.mNo = mNo;
		this.rNo = rNo;
		this.usedYn = usedYn;
		this.usedDate = usedDate;
		this.rName = rName;
	}
	@Override
	public String toString() {
		return "CouponHistoryVo [no=" + no + ", couNo=" + couNo + ", mNo=" + mNo + ", rNo=" + rNo + ", usedYn=" + usedYn
				+ ", usedDate=" + usedDate + ", rName=" + rName + "]";
	}
	private String no;
	private String couNo;
	private String mNo;
	private String rNo;
	private String usedYn;
	private String usedDate;
	private String rName;

}
