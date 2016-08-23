package org.database.service;

import org.database.domain.MessageVO;

public interface MessageService {
	public void addMessage(MessageVO vo) throws Exception;
	public MessageVO readMessage(String user_id, Integer mid) throws Exception;
}