package org.database.service;

import javax.inject.Inject;

import org.database.domain.MessageVO;
import org.database.persistence.MessageDAO;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

	@Inject
	private MessageDAO messageDAO;
	
	@Override
	public void addMessage(MessageVO vo) throws Exception {
		messageDAO.create(vo);
	}

	@Override
	public MessageVO readMessage(String user_id, Integer mid) throws Exception {
		messageDAO.updateState(mid);
		return messageDAO.readMessage(mid);
	}

}
