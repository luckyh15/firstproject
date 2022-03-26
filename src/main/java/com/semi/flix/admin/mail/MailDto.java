package com.semi.flix.admin.mail;

import com.semi.flix.admin.common.AdminBaseDto;

public class MailDto extends AdminBaseDto{
	
	private String seq="";
	private String user_seq="";
	private String id="";
	private String title="";
	private String content="";
	private String date="";
	private String name1="";
	private String name2="";
	private String email1="";
	private String email2="";
	private String user_id="";
	private String toname="";
	private String fromname="";
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getUser_seq() {
		return user_seq;
	}
	public void setUser_seq(String user_seq) {
		this.user_seq = user_seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getToname() {
		return toname;
	}
	public void setToname(String toname) {
		this.toname = toname;
	}
	public String getFromname() {
		return fromname;
	}
	public void setFromname(String fromname) {
		this.fromname = fromname;
	}
	public MailDto(String seq, String user_seq, String id, String title, String content, String date, String name1,
			String name2, String email1, String email2, String user_id, String toname, String fromname) {
		super();
		this.seq = seq;
		this.user_seq = user_seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.date = date;
		this.name1 = name1;
		this.name2 = name2;
		this.email1 = email1;
		this.email2 = email2;
		this.user_id = user_id;
		this.toname = toname;
		this.fromname = fromname;
	}
	public MailDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MailDto [seq=" + seq + ", user_seq=" + user_seq + ", id=" + id + ", title=" + title + ", content="
				+ content + ", date=" + date + ", name1=" + name1 + ", name2=" + name2 + ", email1=" + email1
				+ ", email2=" + email2 + ", user_id=" + user_id + ", toname=" + toname + ", fromname=" + fromname + "]";
	}

}
