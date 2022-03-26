package com.semi.flix.enter;

import com.semi.flix.common.BaseDto;

public class EnterDto extends BaseDto {

	private String board_seq;
	private String genre_code="";
	private String enter_title="";
	private String enter_content="";
	private String enter_images="";
	private String enter_avg_ratings="";
	private String category_code="";
	private String enter_producer="";
	private int enter_hit=0;
	private String wdate="";
	private String enter_productionyear="";
	private String enter_agelimit="";
	private String enter_url="";
	private String star_avg="";
	
	
	public String getStar_avg() {
		return star_avg;
	}
	public void setStar_avg(String star_avg) {
		this.star_avg = star_avg;
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
	public String getEnter_title() {
		return enter_title;
	}
	public void setEnter_title(String enter_title) {
		this.enter_title = enter_title;
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
	public String getCategory_code() {
		return category_code;
	}
	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}
	public String getEnter_producer() {
		return enter_producer;
	}
	public void setEnter_producer(String enter_producer) {
		this.enter_producer = enter_producer;
	}
	public int getEnter_hit() {
		return enter_hit;
	}
	public void setEnter_hit(int enter_hit) {
		this.enter_hit = enter_hit;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
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
	@Override
	public String toString() {
		return "EntertainDto [board_seq=" + board_seq + ", genre_code=" + genre_code + ", enter_title=" + enter_title
				+ ", enter_content=" + enter_content + ", enter_images=" + enter_images + ", enter_avg_ratings="
				+ enter_avg_ratings + ", category_code=" + category_code + ", enter_producer=" + enter_producer
				+ ", enter_hit=" + enter_hit + ", wdate=" + wdate + ", enter_productionyear=" + enter_productionyear
				+ ", enter_agelimit=" + enter_agelimit + ", enter_url=" + enter_url + "]";
	}
	
	
	
}
