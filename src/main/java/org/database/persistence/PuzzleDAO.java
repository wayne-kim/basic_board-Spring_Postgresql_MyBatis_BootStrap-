package org.database.persistence;

import java.util.List;

import org.database.domain.PuzzleVO;

public interface PuzzleDAO {
	public List<PuzzleVO> getPuzzle() throws Exception;
}
