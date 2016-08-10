package org.database.domain;

import java.util.Date;

public class BoardVO {
	private Integer bno;
	private Integer bro_p;
	private Integer bro_c;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date revdate;
	private int viewcnt;
	private Boolean visible;
	
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
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
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public Integer getBro_p() {
		return bro_p;
	}
	public void setBro_p(Integer bro_p) {
		this.bro_p = bro_p;
	}
	public Integer getBro_c() {
		return bro_c;
	}
	public void setBro_c(Integer bro_c) {
		this.bro_c = bro_c;
	}
	public Date getRevdate() {
		return revdate;
	}
	public void setRevdate(Date revdate) {
		this.revdate = revdate;
	}
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", bro_p=" + bro_p + ", bro_c=" + bro_c + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate=" + regdate
				+ ", revdate=" + revdate + ", viewcnt=" + viewcnt + ", visible=" + visible + "]";
	}
}
