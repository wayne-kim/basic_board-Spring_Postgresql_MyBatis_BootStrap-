package org.database.domain;

import java.util.Date;

public class MessageVO {
	private Integer mid;
	private String target_id;
	private String sender;
	private String message;
	private Date opendate;
	private Date senddate;
	
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getTarget_id() {
		return target_id;
	}
	public void setTarget_id(String target_id) {
		this.target_id = target_id;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getOpendate() {
		return opendate;
	}
	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}
	public Date getSenddate() {
		return senddate;
	}
	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}
	
	@Override
	public String toString() {
		return "MessageVO [mid=" + mid + ", target_id=" + target_id + ", sender=" + sender + ", message=" + message + ", opendate=" + opendate + ", senddate=" + senddate + "]";
	}
}
