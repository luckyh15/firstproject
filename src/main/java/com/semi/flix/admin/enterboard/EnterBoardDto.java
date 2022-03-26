package com.semi.flix.admin.enterboard;

import com.semi.flix.admin.common.AdminBaseDto;

public class EnterBoardDto extends AdminBaseDto{
	
	private String board_seq="";
	private String genre_code="";
	private String category_code="";
	private String enter_title="";
	private String enter_producer="";
	private String enter_content="";
	private String enter_images="";
	private String enter_avg_ratings="";
	private int enter_hit=0;
	private String enter_productionyear="";
	private String enter_agelimit="";
	private String enter_url="";
	private String wdate="";
	private String username="";
	private String genre_name="";
	private String category_name="";
	
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
	public String getEnter_title() {
		return enter_title;
	}
	public void setEnter_title(String enter_title) {
		this.enter_title = enter_title;
	}
	public String getEnter_producer() {
		return enter_producer;
	}
	public void setEnter_producer(String enter_producer) {
		this.enter_producer = enter_producer;
	}
	public String getEnter_content() {
		return enter_content;
	}
	public void setEnter_content(String enter_content) {
		this.enter_content = enter_content;
	}
	public String getEnter_images() {
		return enter_images;
	}
	public void setEnter_images(String enter_images) {
		this.enter_images = enter_images;
	}
	public String getEnter_avg_ratings() {
		return enter_avg_ratings;
	}
	public void setEnter_avg_ratings(String enter_avg_ratings) {
		this.enter_avg_ratings = enter_avg_ratings;
	}
	public int getEnter_hit() {
		return enter_hit;
	}
	public void setEnter_hit(int enter_hit) {
		this.enter_hit = enter_hit;
	}
	public String getEnter_productionyear() {
		return enter_productionyear;
	}
	public void setEnter_productionyear(String enter_productionyear) {
		this.enter_productionyear = enter_productionyear;
	}
	public String getEnter_agelimit() {
		return enter_agelimit;
	}
	public void setEnter_agelimit(String enter_agelimit) {
		this.enter_agelimit = enter_agelimit;
	}
	public String getEnter_url() {
		return enter_url;
	}
	public void setEnter_url(String enter_url) {
		this.enter_url = enter_url;
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
	
	public EnterBoardDto(String board_seq, String genre_code, String category_code, String enter_title,
			String enter_producer, String enter_content, String enter_images, String enter_avg_ratings, int enter_hit,
			String enter_productionyear, String enter_agelimit, String enter_url, String wdate, String username,
			String genre_name, String category_name) {
		super();
		this.board_seq = board_seq;
		this.genre_code = genre_code;
		this.category_code = category_code;
		this.enter_title = enter_title;
		this.enter_producer = enter_producer;
		this.enter_content = enter_content;
		this.enter_images = enter_images;
		this.enter_avg_ratings = enter_avg_ratings;
		this.enter_hit = enter_hit;
		this.enter_productionyear = enter_productionyear;
		this.enter_agelimit = enter_agelimit;
		this.enter_url = enter_url;
		this.wdate = wdate;
		this.username = username;
		this.genre_name = genre_name;
		this.category_name = category_name;
	}
	public EnterBoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EnterBoardDto [board_seq=" + board_seq + ", genre_code=" + genre_code + ", category_code="
				+ category_code + ", enter_title=" + enter_title + ", enter_producer=" + enter_producer
				+ ", enter_content=" + enter_content + ", enter_images=" + enter_images + ", enter_avg_ratings="
				+ enter_avg_ratings + ", enter_hit=" + enter_hit + ", enter_productionyear=" + enter_productionyear
				+ ", enter_agelimit=" + enter_agelimit + ", enter_url=" + enter_url + ", wdate=" + wdate + ", username="
				+ username + ", genre_name=" + genre_name + ", category_name=" + category_name + "]";
	}
}
