package com.semi.flix.admin.board;

import com.semi.flix.admin.common.AdminBaseDto;

public class AdminBoardDto extends AdminBaseDto{
	
	private String board_seq="";
	private String genre_code="";
	private String category_code="";
	private String title="";
	private String writer="";
	private String contents="";
	private String images="";
	private String attendance="";
	private int hit=0;
	private String wdate="";
	private String username="";
	private String url="";
	private String tb_name="";

	public AdminBoardDto(String board_seq, String genre_code, String category_code, String title, String writer,
			String contents, String images, String attendance, int hit, String wdate, String username, String url,
			String tb_name) {
		super();
		this.board_seq = board_seq;
		this.genre_code = genre_code;
		this.category_code = category_code;
		this.title = title;
		this.writer = writer;
		this.contents = contents;
		this.images = images;
		this.attendance = attendance;
		this.hit = hit;
		this.wdate = wdate;
		this.username = username;
		this.url = url;
		this.tb_name = tb_name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTb_name() {
		return tb_name;
	}

	public void setTb_name(String tb_name) {
		this.tb_name = tb_name;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getAttendance() {
		return attendance;
	}
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
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
	public AdminBoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BoardDto [board_seq=" + board_seq + ", genre_code=" + genre_code + ", category_code=" + category_code
				+ ", title=" + title + ", writer=" + writer + ", contents=" + contents + ", images=" + images
				+ ", attendance=" + attendance + ", hit=" + hit + ", wdate=" + wdate + ", username=" + username + "]";
	}
}
