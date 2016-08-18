package org.database.persistence;

import java.util.List;

import org.database.domain.BusinessLogVO;

public interface BusinessLogDAO {
	public List<BusinessLogVO> toDayBusinessLog() throws Exception;
}
