package com.semi.flix.Visit;

public class VisitDto {
	
	private String wdate = "";
	private int visit_count = 0;
	private String month = "";
	private String m_cnt = "";
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getM_cnt() {
		return m_cnt;
	}
	public void setM_cnt(String m_cnt) {
		this.m_cnt = m_cnt;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public int getVisit_count() {
		return visit_count;
	}
	public void setVisit_count(int visit_count) {
		this.visit_count = visit_count;
	}
	public VisitDto(String wdate, int visit_count, String month, String m_cnt) {
		super();
		this.wdate = wdate;
		this.visit_count = visit_count;
		this.month = month;
		this.m_cnt = m_cnt;
	}
	public VisitDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
