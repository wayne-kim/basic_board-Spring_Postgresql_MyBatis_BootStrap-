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

}
