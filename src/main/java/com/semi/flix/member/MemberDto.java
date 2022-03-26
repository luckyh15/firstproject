package com.semi.flix.member;

public class MemberDto {
	
	private String user_seq	="";
	private String name	="";	
	private String user_id ="";	
	private String password	="";
	private String nick_name ="";	
	private String email ="";	
	private String phone ="";	
	private String wdate ="";	

	private String zipcode ="";
	private String address1 ="";	
	private String address2 ="";
	private String user_images ="";

	public String getUser_seq() {
		return user_seq;
	}
	public void setUser_seq(String user_seq) {
		this.user_seq = user_seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getUser_images() {
		return user_images;
	}
	public void setUser_images(String user_images) {
		this.user_images = user_images;
	}
	public MemberDto(String user_seq, String name, String user_id, String password, String nick_name, String email,
			String phone, String wdate, String address1, String address2, String zipcode) {
		super();
		this.user_seq = user_seq;
		this.name = name;
		this.user_id = user_id;
		this.password = password;
		this.nick_name = nick_name;
		this.email = email;
		this.phone = phone;
		this.wdate = wdate;
		this.address1 = address1;
		this.address2 = address2;
		this.zipcode = zipcode;
	}
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
