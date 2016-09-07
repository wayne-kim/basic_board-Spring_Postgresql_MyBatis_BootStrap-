package org.database.service;

import java.util.List;

import javax.inject.Inject;

import org.database.domain.PuzzleVO;
import org.database.persistence.PuzzleDAO;
import org.springframework.stereotype.Service;

@Service
public class PuzzleServiceImpl implements PuzzleService {

	@Inject
	private PuzzleDAO puzzleDAO;

	@Override
	public List<PuzzleVO> getPuzzle() throws Exception {
		return puzzleDAO.getPuzzle();
	}
}
