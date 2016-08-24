package org.database.persistence;

import java.util.List;

import org.database.domain.BusinessLogVO;

public interface BusinessLogDAO {
	public void createBusinessLog(BusinessLogVO vo) throws Exception;
	public List<BusinessLogVO> toDayBusinessLog() throws Exception;
	public void updateBusinessLog(BusinessLogVO vo) throws Exception;
	public void deleteBusinessLog(Integer lno, Integer user_num) throws Exception;
}
