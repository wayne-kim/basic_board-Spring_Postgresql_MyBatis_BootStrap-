package org.database.persistence;

import java.util.Date;
import java.util.List;

import org.database.domain.BusinessLogVO;

public interface BusinessLogDAO {
	public void createBusinessLog(BusinessLogVO vo) throws Exception;
	public List<BusinessLogVO> toDayBusinessLog() throws Exception;
	public void updateBusinessLog(BusinessLogVO vo) throws Exception;
	public void deleteBusinessLog(BusinessLogVO vo) throws Exception;
	public List<BusinessLogVO> getInputDateLogs(String date) throws Exception;
}
