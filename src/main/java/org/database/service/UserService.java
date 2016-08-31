package org.database.service;

import java.util.Date;

import org.database.domain.UserVO;
import org.database.dto.LoginDTO;

public interface UserService {
	
	
	public UserVO login(LoginDTO dto) throws Exception;
	
	public void keepLogin(String user_id, String sessionId, Date next) throws Exception;
	
	public UserVO checkLoginBefore(String value);
	
	public String checkOverlap(String user_id) throws Exception;
	
	public void joinRequest(UserVO vo) throws Exception;
}
