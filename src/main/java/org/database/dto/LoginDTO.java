package org.database.dto;

public class LoginDTO {
	private String user_id;
	private String user_pw;
	private String user_name;
	private Integer user_point;
	private Character position_id;
	
	private boolean useCookie;

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

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Integer getUser_point() {
		return user_point;
	}

	public void setUser_point(Integer user_point) {
		this.user_point = user_point;
	}

	public Character getPosition_id() {
		return position_id;
	}

	public void setPosition_id(Character position_id) {
		this.position_id = position_id;
	}

	public boolean isUseCookie() {
		return useCookie;
	}

	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}

	@Override
	public String toString() {
		return "LoginDTO [user_id=" + user_id + ", user_pw=" + user_pw + ", user_name=" + user_name + ", user_point=" + user_point + ", position_id=" + position_id + ", useCookie="
				+ useCookie + "]";
	}
	
}
