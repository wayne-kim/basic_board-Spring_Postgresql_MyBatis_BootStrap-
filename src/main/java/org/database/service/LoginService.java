package org.database.service;

import org.database.domain.LoginVO;


public interface LoginService {
	public LoginVO doorFront(LoginVO loginVO) throws Exception;
	public LoginVO doorKnock(LoginVO loginVO) throws Exception;
}
