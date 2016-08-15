package org.database.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.database.domain.BoardVO;
//import org.database.domain.Criteria;
//import org.database.domain.SearchCriteria;
import org.database.domain.Criteria;
import org.database.domain.SearchCriteria;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "org.database.mapper.BoardMapper";

	// 생성
	@Override
	public void createBoard(BoardVO vo) throws Exception {
		session.insert(namespace + ".createBoard", vo);
	}

	@Override
	public void createComment(BoardVO vo) throws Exception {
		session.insert(namespace + ".createComment", vo);
	}

	// 상세보기
	@Override
	public BoardVO read(Integer bno) throws Exception {
		return session.selectOne(namespace + ".read", bno);
	}

	// 수정
	public void updateBoard(BoardVO vo) throws Exception {
		session.update(namespace + ".updateBoard", vo);
	}

	public void updateComment(BoardVO vo) throws Exception {
		session.update(namespace + ".updateBoard", vo);
	}

	// 삭제
	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(namespace + ".delete", bno);
	}

	// 목록
	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * 10;
		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", cri);
	}

	// 목록 페이징
	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);
	}

	// 검색
	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);
	}
}
