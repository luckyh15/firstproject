package com.semi.flix.notice;

public class NoticeDTO {
	private String notice_seq = "";
	private String notice_title = "";
	private String notice_content = "";
	private String notice_hit = "";
	private String wdate = "";
	private String user_id = "";
	private String id = "";
	public String getNotice_seq() {
		return notice_seq;
	}
	public void setNotice_seq(String notice_seq) {
		this.notice_seq = notice_seq;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public String getNotice_hit() {
		return notice_hit;
	}
	public void setNotice_hit(String notice_hit) {
		this.notice_hit = notice_hit;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public NoticeDTO() {
		super();
		
	}
	public NoticeDTO(String notice_seq, String notice_title, String notice_content, String notice_hit , String wdate, String user_id,
			String id) {
		super();
		this.notice_seq = notice_seq;
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.notice_hit = notice_hit;
		this.wdate = wdate;
		this.user_id = user_id;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "NoticeDTO [notice_seq=" + notice_seq + ", notice_title=" + notice_title + ", notice_content=" + notice_hit
				+ notice_content + ", wdate=" + wdate + ", user_id=" + user_id + ", id=" + id + "]";
	}
	
	
	
	
	
}
