package com.miniproject.phonetail.DTO;

import java.sql.Timestamp;

public class MemberDTO {
	
	private String userid;
	private String pwd;
	private String name;
	private String phone;
	private String email;
	private String address1;
	private String address2;
	private String usestate; 
    private Timestamp indate;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getUsestate() {
		return usestate;
	}
	public void setUsestate(String usestate) {
		this.usestate = usestate;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone + ", email="
				+ email + ", address1=" + address1 + ", address2=" + address2 + ", usestate=" + usestate + ", indate="
				+ indate + "]";
	}
    
    
	
    
}
