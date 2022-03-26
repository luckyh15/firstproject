package com.semi.flix.admin.user;

import com.semi.flix.admin.common.AdminBaseDto;

public class UserDto extends AdminBaseDto{

	private String user_seq="";
	private String user_id="";
	private String password="";
	private String nick_name="";
	private String name="";
	private String email="";
	private String phone="";
	private String address1="";
	private String address2="";
	private String zipcode="";
	private String user_images="";
	private String wdate="";
	
	public String getUser_seq() {
		return user_seq;
	}
	public void setUser_seq(String user_seq) {
		this.user_seq = user_seq;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getUser_images() {
		return user_images;
	}
	public void setUser_images(String user_images) {
		this.user_images = user_images;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public UserDto(String user_seq, String user_id, String password, String nick_name, String name, String email,
			String phone, String address1, String address2, String zipcode, String user_images, String wdate) {
		super();
		this.user_seq = user_seq;
		this.user_id = user_id;
		this.password = password;
		this.nick_name = nick_name;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address1 = address1;
		this.address2 = address2;
		this.zipcode = zipcode;
		this.user_images = user_images;
		this.wdate = wdate;
	}
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserDto [user_seq=" + user_seq + ", user_id=" + user_id + ", password=" + password + ", nick_name="
				+ nick_name + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address1=" + address1
				+ ", address2=" + address2 + ", zipcode=" + zipcode + ", user_images=" + user_images + ", wdate="
				+ wdate + "]";
	}
	
}
