package com.semi.flix.admin.review;

import com.semi.flix.admin.common.AdminBaseDto;

public class ReviewDto extends AdminBaseDto{
	
	private String seq="";
	private String title="";
	private String category_code="";
	private String name="";
	private String genre_code="";
	private String genre_name="";
	private String content="";
	private String category_name="";
	
	public String getGenre_name() {
		return genre_name;
	}
	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory_code() {
		return category_code;
	}
	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre_code() {
		return genre_code;
	}
	public void setGenre_code(String genre_code) {
		this.genre_code = genre_code;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public ReviewDto(String seq, String title, String category_code, String name, String genre_code, String content,
			String category_name, String genre_name) {
		super();
		this.seq = seq;
		this.title = title;
		this.category_code = category_code;
		this.name = name;
		this.genre_code = genre_code;
		this.content = content;
		this.category_name = category_name;
		this.genre_name = genre_name;
	}
	
	public ReviewDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ReviewDto [seq=" + seq + ", title=" + title + ", category_code=" + category_code + ", name=" + name
				+ ", genre_code=" + genre_code + ", content=" + content + ", category_name=" + category_name + ", genre_name=" + genre_name + "]";
	}
}
