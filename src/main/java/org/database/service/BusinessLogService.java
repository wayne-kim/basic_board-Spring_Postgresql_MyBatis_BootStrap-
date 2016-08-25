package org.database.service;

import java.util.List;

import org.database.domain.BusinessLogVO;

public interface BusinessLogService {
	public List<BusinessLogVO> todayBusinessLogs() throws Exception;
	public void createBusinessLog(BusinessLogVO vo) throws Exception;
	public void updateBusinessLog(BusinessLogVO vo) throws Exception;
	public void deleteBusinessLog(BusinessLogVO vo) throws Exception;
	//검색은 나중에 처리
}
