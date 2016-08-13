package org.database.persistence;

import org.database.domain.LoginVO;

public interface LoginDAO {
	
	public LoginVO login(LoginVO vo) throws Exception;
}
