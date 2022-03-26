package com.semi.flix.admin.common;

public class AdminBaseDto {
	protected String key="";
	protected String keyword="";
	protected int pg=0; //현재 페이지
	protected int pageSize=10;
	protected int pgGroup=5;
	protected int start=0;
	protected int rnum=0;
	protected String keyword2="";
	
	public String getKeyword2() {
		return keyword2;
	}
	public void setKeyword2(String keyword2) {
		this.keyword2 = keyword2;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getPg() {
		return pg;
	}
	public void setPg(int pg) {
		this.pg = pg;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPgGroup() {
		return pgGroup;
	}
	public void setPgGroup(int pgGroup) {
		this.pgGroup = pgGroup;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	
	
}
