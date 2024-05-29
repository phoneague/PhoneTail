package com.miniproject.phonetail.DTO;

import java.sql.Date;

public class QuestionDTO {
     
	    private int qseq;
	    private String title;
	    private String content;
	    private Date indate;
	    private String userid;
	    private String qreply;
	    
		public int getQseq() {
			return qseq;
		}
		public void setQseq(int qseq) {
			this.qseq = qseq;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public Date getIndate() {
			return indate;
		}
		public void setIndate(Date indate) {
			this.indate = indate;
		}
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public String getQreply() {
			return qreply;
		}
		public void setQreply(String qreply) {
			this.qreply = qreply;
		}
	    
	    
}
