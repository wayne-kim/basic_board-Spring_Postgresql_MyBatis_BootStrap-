package org.database.domain;

import java.util.Date;

public class CommentVO {
	private Integer cno;
	private Integer bno;
	private String content;
	private String writer;
	
	private Date regdate;
	private Date revdate;
	
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getRevdate() {
		return revdate;
	}
	public void setRevdate(Date revdate) {
		this.revdate = revdate;
	}
	@Override
	public String toString() {
		return "CommentVO [cno=" + cno + ", bno=" + bno + ", content=" + content + ", writer=" + writer + ", regdate=" + regdate + ", revdate=" + revdate + "]";
	}
}
