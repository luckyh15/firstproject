package com.semi.flix.admin.movieboard;

import com.semi.flix.admin.common.AdminBaseDto;

public class MovieBoardDto extends AdminBaseDto{
	
	private String board_seq="";
	private String genre_code="";
	private String category_code="";
	private String movie_title="";
	private String movie_producer="";
	private String movie_content="";
	private String movie_images="";
	private String movie_attendance="";
	private int movie_hit=0;
	private String movie_productionyear="";
	private String movie_agelimit="";
	private String movie_url="";
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
	public String getMovie_url() {
		return movie_url;
	}
	public void setMovie_url(String movie_url) {
		this.movie_url = movie_url;
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
	public String getMovie_title() {
		return movie_title;
	}
	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}
	public String getMovie_producer() {
		return movie_producer;
	}
	public void setMovie_producer(String movie_producer) {
		this.movie_producer = movie_producer;
	}
	public String getMovie_content() {
		return movie_content;
	}
	public void setMovie_content(String movie_content) {
		this.movie_content = movie_content;
	}
	public String getMovie_images() {
		return movie_images;
	}
	public void setMovie_images(String movie_images) {
		this.movie_images = movie_images;
	}
	public String getMovie_attendance() {
		return movie_attendance;
	}
	public void setMovie_attendance(String movie_attendance) {
		this.movie_attendance = movie_attendance;
	}
	public int getMovie_hit() {
		return movie_hit;
	}
	public void setMovie_hit(int movie_hit) {
		this.movie_hit = movie_hit;
	}
	public String getMovie_productionyear() {
		return movie_productionyear;
	}
	public void setMovie_productionyear(String movie_productionyear) {
		this.movie_productionyear = movie_productionyear;
	}
	public String getMovie_agelimit() {
		return movie_agelimit;
	}
	public void setMovie_agelimit(String movie_agelimit) {
		this.movie_agelimit = movie_agelimit;
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
	
	
	public MovieBoardDto(String board_seq, String genre_code, String category_code, String movie_title,
			String movie_producer, String movie_content, String movie_images, String movie_attendance, int movie_hit,
			String movie_productionyear, String movie_agelimit, String movie_url, String wdate, String username,
			String genre_name, String category_name) {
		super();
		this.board_seq = board_seq;
		this.genre_code = genre_code;
		this.category_code = category_code;
		this.movie_title = movie_title;
		this.movie_producer = movie_producer;
		this.movie_content = movie_content;
		this.movie_images = movie_images;
		this.movie_attendance = movie_attendance;
		this.movie_hit = movie_hit;
		this.movie_productionyear = movie_productionyear;
		this.movie_agelimit = movie_agelimit;
		this.movie_url = movie_url;
		this.wdate = wdate;
		this.username = username;
		this.genre_name = genre_name;
		this.category_name = category_name;
	}
	public MovieBoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MovieBoardDto [board_seq=" + board_seq + ", genre_code=" + genre_code + ", category_code="
				+ category_code + ", movie_title=" + movie_title + ", movie_producer=" + movie_producer
				+ ", movie_content=" + movie_content + ", movie_images=" + movie_images + ", movie_attendance="
				+ movie_attendance + ", movie_hit=" + movie_hit + ", movie_productionyear=" + movie_productionyear
				+ ", movie_agelimit=" + movie_agelimit + ", movie_url=" + movie_url + ", wdate=" + wdate + ", username="
				+ username + ", genre_name=" + genre_name + ", category_name=" + category_name + "]";
	}
	
}
