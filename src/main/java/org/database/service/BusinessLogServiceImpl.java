package org.database.service;

import java.util.List;

import javax.inject.Inject;

import org.database.domain.BusinessLogVO;
import org.database.persistence.BusinessLogDAO;
import org.springframework.stereotype.Service;

@Service
class BusinessLogServiceImpl implements BusinessLogService {

	@Inject
	private BusinessLogDAO dao;

	@Override
	public List<BusinessLogVO> todayBusinessLogs() throws Exception {
		return dao.toDayBusinessLog();
	}

	@Override
	public void createBusinessLog(BusinessLogVO vo) throws Exception {
		dao.createBusinessLog(vo);
	}

	@Override
	public void updateBusinessLog(BusinessLogVO vo) throws Exception {
		dao.updateBusinessLog(vo);
	}

	@Override
	public void deleteBusinessLog(BusinessLogVO vo) throws Exception {
		dao.deleteBusinessLog(vo);
	}

	@Override
	public List<BusinessLogVO> getInputDateLogs(String date) throws Exception {
		return dao.getInputDateLogs(date);
	}

}
