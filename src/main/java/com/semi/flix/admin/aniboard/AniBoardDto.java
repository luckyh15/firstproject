package com.semi.flix.admin.aniboard;

import com.semi.flix.admin.common.AdminBaseDto;

public class AniBoardDto extends AdminBaseDto{
	
	private String board_seq="";
	private String genre_code="";
	private String category_code="";
	private String ani_title="";
	private String ani_producer="";
	private String ani_content="";
	private String ani_images="";
	private String ani_avg_ratings="";
	private int ani_hit=0;
	private String ani_productionyear="";
	private String ani_agelimit="";
	private String ani_url="";
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
	public String getAni_title() {
		return ani_title;
	}
	public void setAni_title(String ani_title) {
		this.ani_title = ani_title;
	}
	public String getAni_producer() {
		return ani_producer;
	}
	public void setAni_producer(String ani_producer) {
		this.ani_producer = ani_producer;
	}
	public String getAni_content() {
		return ani_content;
	}
	public void setAni_content(String ani_content) {
		this.ani_content = ani_content;
	}
	public String getAni_images() {
		return ani_images;
	}
	public void setAni_images(String ani_images) {
		this.ani_images = ani_images;
	}
	public String getAni_avg_ratings() {
		return ani_avg_ratings;
	}
	public void setAni_avg_ratings(String ani_avg_ratings) {
		this.ani_avg_ratings = ani_avg_ratings;
	}
	public int getAni_hit() {
		return ani_hit;
	}
	public void setAni_hit(int ani_hit) {
		this.ani_hit = ani_hit;
	}
	public String getAni_productionyear() {
		return ani_productionyear;
	}
	public void setAni_productionyear(String ani_productionyear) {
		this.ani_productionyear = ani_productionyear;
	}
	public String getAni_agelimit() {
		return ani_agelimit;
	}
	public void setAni_agelimit(String ani_agelimit) {
		this.ani_agelimit = ani_agelimit;
	}
	public String getAni_url() {
		return ani_url;
	}
	public void setAni_url(String ani_url) {
		this.ani_url = ani_url;
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
	public AniBoardDto(String board_seq, String genre_code, String category_code, String ani_title, String ani_producer,
			String ani_content, String ani_images, String ani_avg_ratings, int ani_hit, String ani_productionyear,
			String ani_agelimit, String ani_url, String wdate, String username, String genre_name, String category_name) {
		super();
		this.board_seq = board_seq;
		this.genre_code = genre_code;
		this.category_code = category_code;
		this.ani_title = ani_title;
		this.ani_producer = ani_producer;
		this.ani_content = ani_content;
		this.ani_images = ani_images;
		this.ani_avg_ratings = ani_avg_ratings;
		this.ani_hit = ani_hit;
		this.ani_productionyear = ani_productionyear;
		this.ani_agelimit = ani_agelimit;
		this.ani_url = ani_url;
		this.wdate = wdate;
		this.username = username;
		this.genre_name = genre_name;
		this.category_name = category_name;
	}
	
	public AniBoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AniBoardDto [board_seq=" + board_seq + ", genre_code=" + genre_code + ", category_code=" + category_code
				+ ", ani_title=" + ani_title + ", ani_producer=" + ani_producer + ", ani_content=" + ani_content
				+ ", ani_images=" + ani_images + ", ani_avg_ratings=" + ani_avg_ratings + ", ani_hit=" + ani_hit
				+ ", ani_productionyear=" + ani_productionyear + ", ani_agelimit=" + ani_agelimit + ", ani_url="
				+ ani_url + ", wdate=" + wdate + ", username=" + username + "]";
	}

}
