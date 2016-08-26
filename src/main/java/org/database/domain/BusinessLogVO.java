package org.database.domain;

import java.util.Date;

import org.json.JSONObject;

public class BusinessLogVO {
	//시스템 입력 값
	Integer lno;
	Date regdate;
	Date revdate;
	Boolean visible;
	Integer user_num;
	
	//사용자 입력 값
	String log;

	//사용자 아이디와  별명
	String user_id;
	String alias;

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public Integer getLno() {
		return lno;
	}
	public void setLno(Integer lno) {
		this.lno = lno;
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
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	public Integer getUser_num() {
		return user_num;
	}
	public void setUser_num(Integer user_num) {
		this.user_num = user_num;
	}
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
	@Override
	public String toString() {
		return "BusinessLogVO [lno=" + lno + ", regdate=" + regdate + ", revdate=" + revdate + ", visible=" + visible + ", user_num=" + user_num + ", log=" + log + ", user_id="
				+ user_id + ", alias=" + alias + "]";
	}
}