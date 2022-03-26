package com.semi.flix.admin.admincomment;

import com.semi.flix.admin.common.AdminBaseDto;

public class AdminCommentDto extends AdminBaseDto{
	
	private String seq="";
	private String title="";
	private String q_a_seq="";
	private String content="";
	private String wdate="";
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
	public String getQ_a_seq() {
		return q_a_seq;
	}
	public void setQ_a_seq(String q_a_seq) {
		this.q_a_seq = q_a_seq;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	
}
