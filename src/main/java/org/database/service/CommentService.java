package org.database.service;

import java.util.List;

import org.database.domain.CommentVO;
import org.database.domain.Criteria;

public interface CommentService {
	public void addComment(CommentVO vo) throws Exception;
	public List<CommentVO> listComment(Integer bno) throws Exception;
	public void modifyComment(CommentVO vo) throws Exception;
	public void removeComment(Integer cno) throws Exception;
	
	public List<CommentVO> listCommentPage(Integer bno, Criteria cri) throws Exception;
	public int count(Integer bno) throws Exception;
}
