package com.kh.semiPrj.chat.vo;

public class ChatVo {
	
	public ChatVo() {
		
	}
	
	public ChatVo(String mNo, String roomNo, String chat) {
		super();
		this.mNo = mNo;
		this.roomNo = roomNo;
		this.chat = chat;
	}
	
	private String mNo;
	private String roomNo;
	private String chat;
	
	public String getmNo() {
		return mNo;
	}
	public void setmNo(String mNo) {
		this.mNo = mNo;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getChat() {
		return chat;
	}
	public void setChat(String chat) {
		this.chat = chat;
	}
	@Override
	public String toString() {
		return "ChatVo [mNo=" + mNo + ", roomNo=" + roomNo + ", chat=" + chat + "]";
	}

}
