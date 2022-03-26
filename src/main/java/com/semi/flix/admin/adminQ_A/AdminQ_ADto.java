package com.semi.flix.admin.adminQ_A;

import com.semi.flix.admin.common.AdminBaseDto;

public class AdminQ_ADto extends AdminBaseDto{
	
	private String seq="";
	private String title="";
	private String content="";
	private String name="";
	private String date="";
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public AdminQ_ADto(String seq, String title, String content, String name, String date) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.name = name;
		this.date = date;
	}
	public AdminQ_ADto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AdminQ_ADto [seq=" + seq + ", title=" + title + ", content=" + content + ", name=" + name + ", date="
				+ date + "]";
	}
	
	
}
