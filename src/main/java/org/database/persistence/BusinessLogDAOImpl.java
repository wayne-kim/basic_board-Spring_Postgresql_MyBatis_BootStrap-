package org.database.persistence;

import java.util.Date;
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
		session.update(namespace+".updateBusinessLog", vo);
	}

	@Override
	public void deleteBusinessLog(BusinessLogVO vo) throws Exception {
		session.delete(namespace+".deleteBusinessLog", vo);
	}

	@Override
	public List<BusinessLogVO> getInputDateLogs(String date) throws Exception {
		return session.selectList(namespace+".getInputDateBusinessLogs", date);
	}
}
