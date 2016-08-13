package org.database.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.database.domain.LoginVO;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO {
	
	@Inject
	private SqlSession session;

	private static String namespace = "org.database.mapper.LoginMapper";
	
	@Override
	public LoginVO login(LoginVO vo) throws Exception {
		return session.selectOne(namespace + ".knock", vo);
	}
	
}
