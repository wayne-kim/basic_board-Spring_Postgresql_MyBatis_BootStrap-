package org.database.service;

import java.util.List;

import org.database.domain.BoardVO;
//import org.database.domain.Criteria;
//import org.database.domain.SearchCriteria;

public interface BoardService {

  public void registBoard(BoardVO board) throws Exception;
  public void registComment(BoardVO board) throws Exception;
  public BoardVO read(Integer bno) throws Exception;
  public void modifyBoard(BoardVO board) throws Exception;
  public void modifyComment(BoardVO board) throws Exception;
  public void remove(Integer bno) throws Exception;
  public List<BoardVO> listAll() throws Exception;

  //public List<BoardVO> listCriteria(Criteria cri) throws Exception;
  //public int listCountCriteria(Criteria cri) throws Exception;
  //public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception;
  //public int listSearchCount(SearchCriteria cri) throws Exception;
}
