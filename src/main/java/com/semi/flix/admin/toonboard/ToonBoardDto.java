package com.semi.flix.admin.toonboard;

import com.semi.flix.admin.common.AdminBaseDto;

public class ToonBoardDto extends AdminBaseDto{
	
	private String board_seq="";
	private String genre_code="";
	private String category_code="";
	private String toon_title="";
	private String toon_author="";
	private String toon_content="";
	private String toon_images="";
	private int toon_hit=0;
	private String toon_productionyear="";
	private String toon_agelimit="";
	private String toon_url="";
	private String wdate="";
	private String username="";
	private String genre_name="";
	private String category_name="";
	public String getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(String board_seq) {
		this.board_seq = board_seq;
	}
	public String getGenre_code() {
		return genre_code;
	}
	public void setGenre_code(String genre_code) {
		this.genre_code = genre_code;
	}
	public String getCategory_code() {
		return category_code;
	}
	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}
	public String getToon_title() {
		return toon_title;
	}
	public void setToon_title(String toon_title) {
		this.toon_title = toon_title;
	}
	public String getToon_author() {
		return toon_author;
	}
	public void setToon_author(String toon_author) {
		this.toon_author = toon_author;
	}
	public String getToon_content() {
		return toon_content;
	}
	public void setToon_content(String toon_content) {
		this.toon_content = toon_content;
	}
	public String getToon_images() {
		return toon_images;
	}
	public void setToon_images(String toon_images) {
		this.toon_images = toon_images;
	}
	public int getToon_hit() {
		return toon_hit;
	}
	public void setToon_hit(int toon_hit) {
		this.toon_hit = toon_hit;
	}
	public String getToon_productionyear() {
		return toon_productionyear;
	}
	public void setToon_productionyear(String toon_productionyear) {
		this.toon_productionyear = toon_productionyear;
	}
	public String getToon_agelimit() {
		return toon_agelimit;
	}
	public void setToon_agelimit(String toon_agelimit) {
		this.toon_agelimit = toon_agelimit;
	}
	public String getToon_url() {
		return toon_url;
	}
	public void setToon_url(String toon_url) {
		this.toon_url = toon_url;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGenre_name() {
		return genre_name;
	}
	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public ToonBoardDto(String board_seq, String genre_code, String category_code, String toon_title,
			String toon_author, String toon_content, String toon_images, int toon_hit, String toon_productionyear,
			String toon_agelimit, String toon_url, String wdate, String username, String genre_name,
			String category_name) {
		super();
		this.board_seq = board_seq;
		this.genre_code = genre_code;
		this.category_code = category_code;
		this.toon_title = toon_title;
		this.toon_author = toon_author;
		this.toon_content = toon_content;
		this.toon_images = toon_images;
		this.toon_hit = toon_hit;
		this.toon_productionyear = toon_productionyear;
		this.toon_agelimit = toon_agelimit;
		this.toon_url = toon_url;
		this.wdate = wdate;
		this.username = username;
		this.genre_name = genre_name;
		this.category_name = category_name;
	}
	public ToonBoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ToonBoardDto [board_seq=" + board_seq + ", genre_code=" + genre_code + ", category_code="
				+ category_code + ", toon_title=" + toon_title + ", toon_author=" + toon_author + ", toon_content="
				+ toon_content + ", toon_images=" + toon_images + ", toon_hit=" + toon_hit + ", toon_productionyear="
				+ toon_productionyear + ", toon_agelimit=" + toon_agelimit + ", toon_url=" + toon_url + ", wdate="
				+ wdate + ", username=" + username + ", genre_name=" + genre_name + ", category_name=" + category_name
				+ "]";
	}
}
