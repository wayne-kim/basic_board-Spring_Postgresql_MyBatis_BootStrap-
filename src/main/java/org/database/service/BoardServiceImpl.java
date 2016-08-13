package org.database.service;

import java.util.List;

import javax.inject.Inject;

import org.database.domain.BoardVO;
import org.database.domain.Criteria;
import org.database.persistence.BoardDAO;
//import org.database.domain.Criteria;
//import org.database.domain.SearchCriteria;
//import org.database.persistence.BoardDAO;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

  @Inject
  private BoardDAO dao;

  @Override
  public void registBoard(BoardVO board) throws Exception {
    dao.createBoard(board);
  }
  
  @Override
  public void registComment(BoardVO board) throws Exception {
    dao.createComment(board);
  }

  @Override
  public BoardVO read(Integer bno) throws Exception {
    return dao.read(bno);
  }

  @Override
  public void modifyBoard(BoardVO board) throws Exception {
    dao.updateBoard(board);
  }
  
  @Override
  public void modifyComment(BoardVO board) throws Exception {
    dao.updateComment(board);
  }

  @Override
  public void remove(Integer bno) throws Exception {
    dao.delete(bno);
  }
  
  @Override
  public List<BoardVO> listCriteria(Criteria cri) throws Exception {

    return dao.listCriteria(cri);
  }

  @Override
  public int listCountCriteria(Criteria cri) throws Exception {

    return dao.countPaging(cri);
  }

//  @Override
//  public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
//
//    return dao.listSearch(cri);
//  }

//  @Override
//  public int listSearchCount(SearchCriteria cri) throws Exception {
//
//    return dao.listSearchCount(cri);
//  }

}
