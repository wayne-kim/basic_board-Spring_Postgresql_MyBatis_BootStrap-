package org.database.service;

import javax.inject.Inject;

import org.database.domain.LoginVO;
import org.database.persistence.LoginDAO;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Inject
	private LoginDAO dao;
	
	@Override
	public LoginVO doorFront(LoginVO loginVO) throws Exception {
		return null;
	}

	@Override
	public LoginVO doorKnock(LoginVO loginVO) throws Exception {
		return dao.login(loginVO);
	}

}
