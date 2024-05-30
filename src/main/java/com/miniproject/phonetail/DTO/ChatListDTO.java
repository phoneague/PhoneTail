package com.miniproject.phonetail.DTO;

import java.sql.Timestamp;

public class ChatListDTO {

	private int lseq;
	private String sid;
	private String bid;
	private int pseq;
	private Timestamp indate;
	private String model;

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getLseq() {
		return lseq;
	}
	public void setLseq(int lseq) {
		this.lseq = lseq;
	}
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public int getPseq() {
		return pseq;
	}
	public void setPseq(int pseq) {
		this.pseq = pseq;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
}
