package com.kh.semiPrj.review.vo;

public class ReviewVo {

	public ReviewVo() {

	}

	public ReviewVo(String no, int score, String restaurant, String writer, String reNo, String content,
			String releaseYn, String deleteYn, String enrollDate, String updateDate) {
		super();
		this.no = no;
		this.score = score;
		this.restaurant = restaurant;
		this.writer = writer;
		this.reNo = reNo;
		this.content = content;
		this.releaseYn = releaseYn;
		this.deleteYn = deleteYn;
		this.enrollDate = enrollDate;
		this.updateDate = updateDate;
	}

	private String no;
	private int score;
	private String restaurant;
	private String writer;
	private String reNo;
	private String content;
	private String releaseYn;
	private String deleteYn;
	private String enrollDate;
	private String updateDate;

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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getReNo() {
		return reNo;
	}

	public void setReNo(String reNo) {
		this.reNo = reNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReleaseYn() {
		return releaseYn;
	}

	public void setReleaseYn(String releaseYn) {
		this.releaseYn = releaseYn;
	}

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "ReviewVo [no=" + no + ", score=" + score + ", restaurant=" + restaurant + ", writer=" + writer
				+ ", reNo=" + reNo + ", content=" + content + ", releaseYn=" + releaseYn + ", deleteYn=" + deleteYn
				+ ", enrollDate=" + enrollDate + ", updateDate=" + updateDate + "]";
	}

}
