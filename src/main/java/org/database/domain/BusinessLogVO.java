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
	Boolean result;

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
	public Boolean getResult() {
		return result;
	}
	public void setResult(Boolean result) {
		this.result = result;
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
	public String toString() {
		return "BusinessLogVO [lno=" + lno + ", regdate=" + regdate + ", revdate=" + revdate + ", visible=" + visible + ", user_num=" + user_num + ", log=" + log + ", result="
				+ result + "]";
	}
}