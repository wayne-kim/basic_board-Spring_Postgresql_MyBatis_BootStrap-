package org.database.service;

import java.util.List;

import org.database.domain.BusinessLogVO;

public interface BusinessLogService {
	public List<BusinessLogVO> todayBusinessLogs() throws Exception;
}
