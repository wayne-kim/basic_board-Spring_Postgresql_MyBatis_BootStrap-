package org.database.domain;

public class LoginVO {
	private String user_id;
	private String user_pw;
	private String alias;
	public String getUser_id() {
		return user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "LoginVO [user_id=" + user_id + ", user_pw=" + user_pw + ", alias=" + alias + "]";
	}
}