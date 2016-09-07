package org.database.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.database.domain.PuzzleVO;
import org.springframework.stereotype.Repository;

@Repository
public class PuzzleDAOImpl implements PuzzleDAO {
	
	@Inject
	private SqlSession session;
	
	private static final String namespace = "org.database.mapper.PuzzleMapper";
	
	@Override
	public List<PuzzleVO> getPuzzle() throws Exception {
		return session.selectList(namespace+".puzzles");
	}

}
