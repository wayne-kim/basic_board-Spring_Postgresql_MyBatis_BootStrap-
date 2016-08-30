package org.database.service;

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

}
