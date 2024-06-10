package com.miniproject.phonetail.DTO;

import java.sql.Timestamp;

public class ProductDTO {
	
	private int pseq;
	private String brand;
	private String model;
	private int price;
	private String comment;
	private String image;
	private String saveimagefile;
	private String sellstate;
	private String userid;
	private Timestamp indate;
	private int readcount;
	private int wantcount;
	

	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getWantcount() {
		return wantcount;
	}
	public void setWantcount(int wantcount) {
		this.wantcount = wantcount;
	}
	public int getPseq() {
		return pseq;
	}
	public void setPseq(int pseq) {
		this.pseq = pseq;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSaveimagefile() {
		return saveimagefile;
	}
	public void setSaveimagefile(String saveimagefile) {
		this.saveimagefile = saveimagefile;
	}
	public String getSellstate() {
		return sellstate;
	}
	public void setSellstate(String sellstate) {
		this.sellstate = sellstate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
}
