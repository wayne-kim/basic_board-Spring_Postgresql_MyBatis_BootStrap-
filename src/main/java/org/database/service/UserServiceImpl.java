package org.database.service;

import java.util.Date;

import javax.inject.Inject;

import org.database.domain.UserVO;
import org.database.dto.LoginDTO;
import org.database.persistence.UserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO dao;
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}

	@Override
	public void keepLogin(String user_id, String sessionId, Date next) throws Exception {
		dao.keepLogin(user_id, sessionId, next);
	}

	@Override
	public UserVO checkLoginBefore(String value) {
		return dao.checkUserWithSessionKey(value);
	}

}
