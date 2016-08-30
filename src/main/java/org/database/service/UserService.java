package org.database.service;

import org.database.domain.UserVO;
import org.database.dto.LoginDTO;

public interface UserService {
	public UserVO login(LoginDTO dto) throws Exception;
}
