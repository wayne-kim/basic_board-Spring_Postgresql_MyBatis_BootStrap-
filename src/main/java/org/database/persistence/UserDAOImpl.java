package org.database.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.database.domain.UserVO;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.database.mapper.UserMapper";

	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".getTime");
	}

	@Override
	public void insertUser(UserVO vo) {
		// TODO Auto-generated method stub
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
}
