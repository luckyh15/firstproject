package com.semi.flix.admin.member;

public class AdminMemberDto {
	private String id="";
	private String userid="";
	private String password="";
	private String username="";
	private String email="";
	private String wdate="";
	private String nickname="";
	private String phone="";
	private String zipcode="";
	private String address1="";
	private String address2="";
	private String user_images="";
	private String m="";
	private String a="";
	private String t="";
	private String d="";
	private String e="";
	
	public String getM() {
		return m;
	}
	public void setM(String m) {
		this.m = m;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	public String getE() {
		return e;
	}
	public void setE(String e) {
		this.e = e;
	}
	public String getUser_images() {
		return user_images;
	}
	public void setUser_images(String user_images) {
		this.user_images = user_images;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	
	public AdminMemberDto(String id, String userid, String password, String username, String email, String wdate,
			String nickname, String phone, String zipcode, String address1, String address2, String user_images,
			String m, String a, String t, String d, String e) {
		super();
		this.id = id;
		this.userid = userid;
		this.password = password;
		this.username = username;
		this.email = email;
		this.wdate = wdate;
		this.nickname = nickname;
		this.phone = phone;
		this.zipcode = zipcode;
		this.address1 = address1;
		this.address2 = address2;
		this.user_images = user_images;
		this.m = m;
		this.a = a;
		this.t = t;
		this.d = d;
		this.e = e;
	}
	
	public AdminMemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AdminMemberDto [id=" + id + ", userid=" + userid + ", password=" + password + ", username=" + username
				+ ", email=" + email + ", wdate=" + wdate + ", nickname=" + nickname + ", phone=" + phone + ", zipcode="
				+ zipcode + ", address1=" + address1 + ", address2=" + address2 + ", user_images=" + user_images
				+ ", m=" + m + ", a=" + a + ", t=" + t + ", d=" + d + ", e=" + e + "]";
	}
	
	
}
