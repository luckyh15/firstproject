package com.semi.flix.comment;

import com.semi.flix.common.BaseDto;

public class CommentDto extends BaseDto {

	
	private String review_seq="";
	private String user_seq="";
	private String board_seq="";
	private String content="";
	private String wdate="";
	private String star_point="";
	private String category_code="";
	private String nick_name="";
	private String user_images="";
	
	
	public String getReview_seq() {
		return review_seq;
	}
	public void setReview_seq(String review_seq) {
		this.review_seq = review_seq;
	}
	public String getUser_seq() {
		return user_seq;
	}
	public void setUser_seq(String user_seq) {
		this.user_seq = user_seq;
	}
	public String getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(String board_seq) {
		this.board_seq = board_seq;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public String getStar_point() {
		return star_point;
	}
	public void setStar_point(String star_point) {
		this.star_point = star_point;
	}
	
	public String getCategory_code() {
		return category_code;
	}
	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getUser_images() {
		return user_images;
	}
	public void setUser_images(String user_images) {
		this.user_images = user_images;
	}
	@Override
	public String toString() {
		return "CommentDto [review_seq=" + review_seq + ", user_seq=" + user_seq + ", board_seq=" + board_seq
				+ ", content=" + content + ", wdate=" + wdate + ", star_point=" + star_point + ", category_code="
				+ category_code + ", nick_name=" + nick_name + ", user_images=" + user_images + "]";
	}
	
	
	
	
	
	
	
	
	
}
