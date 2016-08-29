package org.database.persistence;

import java.util.List;

import org.database.domain.BoardVO;
//import org.database.domain.Criteria;
//import org.database.domain.SearchCriteria;
import org.database.domain.Criteria;
import org.database.domain.SearchCriteria;

public interface BoardDAO {

  public void create(BoardVO vo) throws Exception;
  public BoardVO read(Integer bno) throws Exception;
  public void update(BoardVO vo) throws Exception;
  public void delete(Integer bno) throws Exception;
  public List<BoardVO> listPage(int page) throws Exception;
  public List<BoardVO> listCriteria(Criteria cri) throws Exception;
  public int countPaging(Criteria cri) throws Exception;
  
  //use for dynamic sql
  public List<BoardVO> listSearch(SearchCriteria cri)throws Exception;
  public int listSearchCount(SearchCriteria cri)throws Exception;

  //코멘드 수 세기
  public void updateCommentCnt(Integer bno, int amount) throws Exception;
  
  //조회수 갱신
  public void updateViewCnt(Integer bno) throws Exception;
  
  //파일 첨부
  public void addAttach(String fullName) throws Exception;
  public List<String> getAttach(Integer bno) throws Exception;
}
