package org.database.service;

import java.util.List;

import javax.inject.Inject;

import org.database.domain.CommentVO;
import org.database.domain.Criteria;
import org.database.persistence.BoardDAO;
import org.database.persistence.CommentDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentServieImpl implements CommentService {
	@Inject
	private CommentDAO dao;
	
	@Inject
	private BoardDAO boardDAO;
	
	@Transactional
	@Override
	public void addComment(CommentVO vo) throws Exception {
		dao.create(vo);
		boardDAO.updateCommentCnt(vo.getBno(), 1);
	}

	@Override
	public List<CommentVO> listComment(Integer bno) throws Exception {
		return dao.list(bno);
	}

	@Override
	public void modifyComment(CommentVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void removeComment(Integer cno) throws Exception {
		int bno = dao.getBno(cno);
		dao.delete(cno);
		boardDAO.updateCommentCnt(bno, -1);
	}

	@Override
	public List<CommentVO> listCommentPage(Integer bno, Criteria cri) throws Exception {
		return dao.listPage(bno, cri);
	}

	@Override
	public int count(Integer bno) throws Exception {
		return dao.count(bno);
	}
}
