package org.database.persistence;

import org.database.domain.UserVO;

public interface UserDAO {
	public String getTime();
	
	public void insertUser(UserVO vo);
	
	public UserVO readUser(String user_id) throws Exception;
	
	public UserVO readWithPW(String user_id, String user_pw) throws Exception; 
}
