package com.miniproject.phonetail.DTO;

import java.sql.Timestamp;

public class ReportDTO {
	private int reseq;
	private int pseq;
	private String userid;
	private int retype;
	private String recontent;
	private String restate;
	private Timestamp indate;
	private String pid;
	
	public int getReseq() {
		return reseq;
	}
	public void setReseq(int reseq) {
		this.reseq = reseq;
	}
	public int getPseq() {
		return pseq;
	}
	public void setPseq(int pseq) {
		this.pseq = pseq;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getRetype() {
		return retype;
	}
	public void setRetype(int retype) {
		this.retype = retype;
	}
	public String getRecontent() {
		return recontent;
	}
	public void setRecontent(String recontent) {
		this.recontent = recontent;
	}
	public String getRestate() {
		return restate;
	}
	public void setRestate(String restate) {
		this.restate = restate;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "ReportDTO [reseq=" + reseq + ", pseq=" + pseq + ", userid=" + userid + ", retype=" + retype
				+ ", recontent=" + recontent + ", restate=" + restate + ", indate=" + indate + ", pid=" + pid + "]";
	}
	
	
	
	
	
	
	
}
