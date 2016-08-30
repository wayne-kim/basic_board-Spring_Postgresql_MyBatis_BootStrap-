package org.database.persistence;

import java.util.Date;

import org.database.domain.UserVO;
import org.database.dto.LoginDTO;

public interface UserDAO {
	/*
	public String getTime();
	
	public void insertUser(UserVO vo);
	
	public UserVO readUser(String user_id) throws Exception;
	public UserVO readWithPW(String user_id, String user_pw) throws Exception;
	*/
	public UserVO login(LoginDTO dto) throws Exception;
	public void keepLogin(String user_id, String sessionId, Date next);
	public UserVO checkUserWithSessionKey(String value);
}

