package com.semi.flix.admin.dramaboard;

import com.semi.flix.admin.common.AdminBaseDto;

public class DramaBoardDto extends AdminBaseDto{

	private String board_seq="";
	private String genre_code="";
	private String category_code="";
	private String drama_title="";
	private String drama_producer="";
	private String drama_content="";
	private String drama_images="";
	private String drama_avg_ratings="";
	private int drama_hit=0;
	private String drama_productionyear="";
	private String drama_agelimit="";
	private String drama_url="";
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
	public String getDrama_title() {
		return drama_title;
	}
	public void setDrama_title(String drama_title) {
		this.drama_title = drama_title;
	}
	public String getDrama_producer() {
		return drama_producer;
	}
	public void setDrama_producer(String drama_producer) {
		this.drama_producer = drama_producer;
	}
	public String getDrama_content() {
		return drama_content;
	}
	public void setDrama_content(String drama_content) {
		this.drama_content = drama_content;
	}
	public String getDrama_images() {
		return drama_images;
	}
	public void setDrama_images(String drama_images) {
		this.drama_images = drama_images;
	}
	public String getDrama_avg_ratings() {
		return drama_avg_ratings;
	}
	public void setDrama_avg_ratings(String drama_avg_ratings) {
		this.drama_avg_ratings = drama_avg_ratings;
	}
	public int getDrama_hit() {
		return drama_hit;
	}
	public void setDrama_hit(int drama_hit) {
		this.drama_hit = drama_hit;
	}
	public String getDrama_productionyear() {
		return drama_productionyear;
	}
	public void setDrama_productionyear(String drama_productionyear) {
		this.drama_productionyear = drama_productionyear;
	}
	public String getDrama_agelimit() {
		return drama_agelimit;
	}
	public void setDrama_agelimit(String drama_agelimit) {
		this.drama_agelimit = drama_agelimit;
	}
	public String getDrama_url() {
		return drama_url;
	}
	public void setDrama_url(String drama_url) {
		this.drama_url = drama_url;
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
	public DramaBoardDto(String board_seq, String genre_code, String category_code, String drama_title,
			String drama_producer, String drama_content, String drama_images, String drama_avg_ratings, int drama_hit,
			String drama_productionyear, String drama_agelimit, String drama_url, String wdate, String username, String genre_name, String category_name) {
		super();
		this.board_seq = board_seq;
		this.genre_code = genre_code;
		this.category_code = category_code;
		this.drama_title = drama_title;
		this.drama_producer = drama_producer;
		this.drama_content = drama_content;
		this.drama_images = drama_images;
		this.drama_avg_ratings = drama_avg_ratings;
		this.drama_hit = drama_hit;
		this.drama_productionyear = drama_productionyear;
		this.drama_agelimit = drama_agelimit;
		this.drama_url = drama_url;
		this.wdate = wdate;
		this.username = username;
		this.genre_name = genre_name;
		this.category_name = category_name;
	}

	public DramaBoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DramaBoardDto [board_seq=" + board_seq + ", genre_code=" + genre_code + ", category_code="
				+ category_code + ", drama_title=" + drama_title + ", drama_producer=" + drama_producer
				+ ", drama_content=" + drama_content + ", drama_images=" + drama_images + ", drama_avg_ratings="
				+ drama_avg_ratings + ", drama_hit=" + drama_hit + ", drama_productionyear=" + drama_productionyear
				+ ", drama_agelimit=" + drama_agelimit + ", drama_url=" + drama_url + ", wdate=" + wdate + ", username="
				+ username + "]";
	}
	
	
	
}
