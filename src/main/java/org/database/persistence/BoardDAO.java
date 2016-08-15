package org.database.persistence;

import java.util.List;

import org.database.domain.BoardVO;
//import org.database.domain.Criteria;
//import org.database.domain.SearchCriteria;
import org.database.domain.Criteria;
import org.database.domain.SearchCriteria;

public interface BoardDAO {

  public void createBoard(BoardVO vo) throws Exception;
  public void createComment(BoardVO vo) throws Exception;
  public BoardVO read(Integer bno) throws Exception;
  public void updateBoard(BoardVO vo) throws Exception;
  public void updateComment(BoardVO vo) throws Exception;
  public void delete(Integer bno) throws Exception;
  public List<BoardVO> listPage(int page) throws Exception;
  public List<BoardVO> listCriteria(Criteria cri) throws Exception;
  public int countPaging(Criteria cri) throws Exception;
  
  //use for dynamic sql
  public List<BoardVO> listSearch(SearchCriteria cri)throws Exception;
  public int listSearchCount(SearchCriteria cri)throws Exception;

}
