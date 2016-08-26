package org.database.persistence;

import java.util.List;

import org.database.domain.CommentVO;
import org.database.domain.Criteria;

public interface CommentDAO {
	public List<CommentVO> list(Integer bno) throws Exception;
	public void create(CommentVO vo) throws Exception;
	public void update(CommentVO vo) throws Exception;
	public void delete(Integer cno) throws Exception;
	//페이징을 위한 녀석
	public List<CommentVO> listPage(Integer bno, Criteria cri) throws Exception;
	public int count(Integer bno) throws Exception;

	//코멘트 삭제 후 게시물 코덴스 수 변경을 위한 쿼리
	public int getBno(Integer cno) throws Exception;
}
