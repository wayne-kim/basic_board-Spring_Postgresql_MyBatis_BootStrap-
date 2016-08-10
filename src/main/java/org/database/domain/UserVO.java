package org.database.domain;

import org.json.JSONObject;

public class UserVO {
	private Integer id;
	private String user_id;
	private String user_pw;
	private Character position_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public Character getPosition_id() {
		return position_id;
	}
	public void setPosition_id(Character position_id) {
		this.position_id = position_id;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", user_id=" + user_id + ", user_pw=" + user_pw + ", position_id=" + position_id + "]";
	}
	
}
