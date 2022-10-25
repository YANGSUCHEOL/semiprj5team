package com.kh.semiPrj.community.vo;

public class CategoryVo {

	
	
	public CategoryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CategoryVo(String cNo, String name) {
		super();
		this.cNo = cNo;
		this.name = name;
	}


	private String cNo;
	private String name;
	public String getcNo() {
		return cNo;
	}


	public void setcNo(String cNo) {
		this.cNo = cNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "CategoryVo [cNo=" + cNo + ", name=" + name + "]";
	}
	
	
	
}
