package com.kh.semiPrj.restaurant.vo;

public class RestaurantVo {
	
	public RestaurantVo() {
		
	}
	
	public RestaurantVo(String no, String district, String type, String name, String address, String dayoff,
			String phone, String open, String close, String regYn, String photo) {
		super();
		this.no = no;
		this.district = district;
		this.type = type;
		this.name = name;
		this.address = address;
		this.dayoff = dayoff;
		this.phone = phone;
		this.open = open;
		this.close = close;
		this.regYn = regYn;
		this.photo = photo;
	}
	
	private String no;
	private String district;
	private String type;
	private String name;
	private String address;
	private String dayoff;
	private String phone;
	private String open;
	private String close;
	private String regYn;
	private String photo;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDayoff() {
		return dayoff;
	}
	public void setDayoff(String dayoff) {
		this.dayoff = dayoff;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getClose() {
		return close;
	}
	public void setClose(String close) {
		this.close = close;
	}
	public String getRegYn() {
		return regYn;
	}
	public void setRegYn(String regYn) {
		this.regYn = regYn;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "RestaurantVo [no=" + no + ", district=" + district + ", type=" + type + ", name=" + name + ", address="
				+ address + ", dayoff=" + dayoff + ", phone=" + phone + ", open=" + open + ", close=" + close
				+ ", regYn=" + regYn + ", photo=" + photo + "]";
	}

}
