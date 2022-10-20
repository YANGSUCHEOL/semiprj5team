package faq.vo;

public class FaqVo {

	
	@Override
	public String toString() {
		return "FaqVo [no=" + no + ", title=" + title + ", content=" + content + ", enrollDate=" + enrollDate
				+ ", updateDate=" + updateDate + ", status=" + status + "]";
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public FaqVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FaqVo(String no, String title, String content, String enrollDate, String updateDate, String status) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.updateDate = updateDate;
		this.status = status;
	}
	private String no;
	private String title;
	private String content;
	private String enrollDate;
	private String updateDate;
	private String status;
}
