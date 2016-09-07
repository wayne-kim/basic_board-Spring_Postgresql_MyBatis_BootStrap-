package org.database.service;

import java.util.List;

import org.database.domain.PuzzleVO;

public interface PuzzleService {
	public List<PuzzleVO> getPuzzle() throws Exception;
}
