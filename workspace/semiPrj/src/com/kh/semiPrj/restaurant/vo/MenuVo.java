package com.kh.semiPrj.restaurant.vo;

public class MenuVo {
	
public MenuVo() {
		
	}
	
	public MenuVo(String no, String name, String price, String photo) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.photo = photo;
	}

	private String no;
	private String name;
	private String price;
	private String photo;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
