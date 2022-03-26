package com.semi.flix.search;

import com.semi.flix.common.BaseDto;

public class SearchDto extends BaseDto{
	private String category_code="";
	private String board_seq="";
	private String title="";
	private String producer="";
	private String images="";
	private String genre_name="";
	private String ratings="";
	private String star_avg="";
	
	public String getStar_avg() {
		return star_avg;
	}
	public void setStar_avg(String star_avg) {
		this.star_avg = star_avg;
	}
	public String getCategory_code() {
		return category_code;
	}
	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}
	public String getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(String board_seq) {
		this.board_seq = board_seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getGenre_name() {
		return genre_name;
	}
	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}
	public String getRatings() {
		return ratings;
	}
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	
	@Override
	public String toString() {
		return "SearchDto [category_code=" + category_code + ", board_seq=" + board_seq + ", title=" + title
				+ ", producer=" + producer + ", images=" + images + ", genre_name=" + genre_name + ", ratings="
				+ ratings + "]";
	}
	public SearchDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchDto(String category_code, String board_seq, String title, String producer, String images,
			String genre_name, String ratings) {
		super();
		this.category_code = category_code;
		this.board_seq = board_seq;
		this.title = title;
		this.producer = producer;
		this.images = images;
		this.genre_name = genre_name;
		this.ratings = ratings;
	}
	
	
}