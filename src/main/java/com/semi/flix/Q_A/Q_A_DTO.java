package com.semi.flix.Q_A;

import java.util.Date;

public class Q_A_DTO {

	private String user_seq = "";
	private String q_a_seq = "";
	private String q_a_title = "";
	private String q_a_contents = "";
	private Date q_a_wdate;
	private int q_a_hit = 0;
	private String user_id = "";
	
	
	

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(String user_seq) {
		this.user_seq = user_seq;
	}

	public String getQ_a_seq() {
		return q_a_seq;
	}

	public void setQ_a_seq(String q_a_seq) {
		this.q_a_seq = q_a_seq;
	}

	public String getQ_a_title() {
		return q_a_title;
	}

	public void setQ_a_title(String q_a_title) {
		this.q_a_title = q_a_title;
	}

	public String getQ_a_contents() {
		return q_a_contents;
	}

	public void setQ_a_contents(String q_a_contents) {
		this.q_a_contents = q_a_contents;
	}

	public Date getQ_a_wdate() {
		return q_a_wdate;
	}

	public void setQ_a_wdate(Date q_a_wdate) {
		this.q_a_wdate = q_a_wdate;
	}

	public int getQ_a_hit() {
		return q_a_hit;
	}

	public void setQ_a_hit(int q_a_hit) {
		this.q_a_hit = q_a_hit;
	}

	public Q_A_DTO() {
		super();

	}

	public Q_A_DTO(String user_seq, String q_a_seq, String q_a_title, String q_a_contents, Date q_a_wdate,
			int q_a_hit, String user_id) {
		super();
		this.user_seq = user_seq;
		this.q_a_seq = q_a_seq;
		this.q_a_title = q_a_title;
		this.q_a_contents = q_a_contents;
		this.q_a_wdate = q_a_wdate;
		this.q_a_hit = q_a_hit;
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Q_A_DTO [user_seq=" + user_seq + ", q_a_seq=" + q_a_seq + ", q_a_title=" + q_a_title + ", q_a_contents="
				+ q_a_contents + ", q_a_wdate=" + q_a_wdate + ", q_a_hit=" + q_a_hit + ", user_id=" + user_id + "]";
	}

	

}
