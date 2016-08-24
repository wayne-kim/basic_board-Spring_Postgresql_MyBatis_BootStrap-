package org.database.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.database.domain.BusinessLogVO;
import org.springframework.stereotype.Repository;

@Repository
public class BusinessLogDAOImpl implements BusinessLogDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "org.database.mapper.BusinessLogMapper";
	
	@Override
	public List<BusinessLogVO> toDayBusinessLog() throws Exception {
		return session.selectList(namespace+".todayBusinessLogs");
	}

	@Override
	public void createBusinessLog(BusinessLogVO vo) throws Exception {
		session.insert(namespace+".createBusinessLog", vo);
	}

	@Override
	public void updateBusinessLog(BusinessLogVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBusinessLog(Integer lno, Integer user_num) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
