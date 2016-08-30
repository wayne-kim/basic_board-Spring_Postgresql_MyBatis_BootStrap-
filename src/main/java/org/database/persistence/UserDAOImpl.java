package org.database.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.database.domain.UserVO;
import org.database.dto.LoginDTO;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{
	@Inject
	private SqlSession session;
	
	private static final String namespace = "org.database.mapper.UserMapper";
	/*
	@Override
	public String getTime() {
		return sqlSession.selectOne(namespace+".getTime");
	}
	@Override
	public void insertUser(UserVO vo) {
		sqlSession.insert(namespace+".insertUser", vo);
	}
	@Override
	public UserVO readUser(String user_id) throws Exception {
		return (UserVO)sqlSession.selectOne(namespace+".selectUser", user_id);
	}
	@Override
	public UserVO readWithPW(String user_id, String user_pw) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("user_id", user_id);
		paramMap.put("user_pw", user_pw);
		
		return (UserVO)sqlSession.selectOne(namespace+".readWithPW", paramMap);
	}
	*/
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return session.selectOne(namespace +".login", dto);
	}
	
	@Override
	public void keepLogin(String user_id, String sessionId, Date next) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("user_id", user_id);
		paramMap.put("sessionId", sessionId);
		paramMap.put("next", next);
		
		session.update(namespace+".keepLogin", paramMap);
	}
	@Override
	public UserVO checkUserWithSessionKey(String value) {
		return session.selectOne(namespace+".checkUserWithSessionKey", value);
	}
}
