package com.kh.semiPrj.reservation.vo;

public class ReservationVo {
	
	public ReservationVo() {
		
	}

	public ReservationVo(String no, String restaurant, String member, String cnt, String date, String time,
			String coupon, String request) {
		super();
		this.no = no;
		this.restaurant = restaurant;
		this.member = member;
		this.cnt = cnt;
		this.date = date;
		this.time = time;
		this.coupon = coupon;
		this.request = request;
	}
	
	private String no;
	private String restaurant;
	private String member;
	private String cnt;
	private String date;
	private String time;
	private String coupon;
	private String request;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	@Override
	public String toString() {
		return "ReservationVo [no=" + no + ", restaurant=" + restaurant + ", member=" + member + ", cnt=" + cnt
				+ ", date=" + date + ", time=" + time + ", coupon=" + coupon + ", request=" + request + "]";
	}
	
}
