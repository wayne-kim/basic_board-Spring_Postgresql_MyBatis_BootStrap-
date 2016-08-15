package org.database.test;

import java.util.List;

import javax.inject.Inject;

import org.database.domain.BoardVO;
import org.database.domain.SearchCriteria;
//import org.database.domain.Criteria;
//import org.database.domain.SearchCriteria;
import org.database.persistence.BoardDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class BoardDAOTest {

	@Inject
	private BoardDAO dao;

	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

//	@Test
//	public void testURI2() throws Exception {
//		UriComponents uriComponents = UriComponentsBuilder.newInstance()
//				.path("/{moduel}/{page}")
//				.queryParam("bno", "55")
//				.queryParam("prePageNum",20)
//				.build()
//				.expand("board1","read")
//				.encode();
//		
//		logger.info(uriComponents.toString());
//	}
	
	/*
	@Test
	public void testURI() throws Exception {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.path("/board1/read")
				.queryParam("bno", 50)
				.queryParam("perPageNum", 20)
				.build();
		
		logger.info(uriComponents.toString());
	}
	*/
	
	/*
	@Test
	public void testListCriteria() throws Exception{
		Criteria cri = new Criteria();
		cri.setPage(1);
		cri.setPerPageNum(10);
		
		List<BoardVO> list = dao.listCriteria(cri);
		for(BoardVO boardVO : list){
			logger.info(boardVO.toString());
		}
	}
	*/
	
	/*
	@Test
	public void testListPage() throws Exception{
		int page = 2;
		
		List<BoardVO> list = dao.listPage(page);
		
		for(BoardVO boardVO : list){
			logger.info(boardVO.toString());
		}
	}
	*/
	
	/*
	@Test
	public void testCreate() throws Exception {
		BoardVO board = new BoardVO();
		
		for(int i=1000;i<1000000;i++){
			board.setTitle("TEST"+i);
			board.setContent("TEST 글을 "+i+"번째 입력");
			dao.createBoard(board);
		}
	}
	*/

	/*
	@Test
	public void testRead() throws Exception {
		logger.info(dao.read(1).toString());
	}
	*/
	/*
	@Test
	public void testUpdate1() throws Exception {
		BoardVO board = new BoardVO();
		board.setBno(1);
		board.setTitle("수정된 글입니다.");
		board.setContent("수정 테스트 ");
		dao.updateBoard(board);
	}

	@Test
	public void testUpdate2() throws Exception {
		BoardVO board = new BoardVO();
		board.setBro_p(1);
		board.setBro_c(1);
		board.setContent("수정 테스트 ");
		dao.updateBoard(board);
	}
	
	@Test
	public void testListAll() throws Exception {
		logger.info(dao.listAll().toString());
	}
	*/
	
	/*
	@Test
	public void testDelete() throws Exception {
		dao.delete(1);
	}
	*/

//	@Test
//	public void testListPage() throws Exception {
//		int page = 3;
//		List<BoardVO> list = dao.listPage(page);
//		for (BoardVO boardVO : list) {
//			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
//		}
//	}

	// @Test
	// public void testListCriteria() throws Exception {
	//
	// Criteria cri = new Criteria();
	// cri.setPage(2);
	// cri.setPerPageNum(20);
	//
	// List<BoardVO> list = dao.listCriteria(cri);
	//
	// for (BoardVO boardVO : list) {
	// logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
	// }
	// }

	// @Test
	// public void testURI() throws Exception {
	//
	// UriComponents uriComponents =
	// UriComponentsBuilder.newInstance().path("/board/read").queryParam("bno",
	// 12)
	// .queryParam("perPageNum", 20).build();
	//
	// logger.info("/board/read?bno=12&perPageNum=20");
	// logger.info(uriComponents.toString());
	//
	// }

	// @Test
	// public void testURI2() throws Exception {
	//
	// UriComponents uriComponents =
	// UriComponentsBuilder.newInstance().path("/{module}/{page}").queryParam("bno",
	// 12)
	// .queryParam("perPageNum", 20).build().expand("board", "read").encode();
	//
	// logger.info("/board/read?bno=12&perPageNum=20");
	// logger.info(uriComponents.toString());
	// }

	 @Test
	 public void testDynamic1() throws Exception {
	 SearchCriteria cri = new SearchCriteria();
	 cri.setPage(1);
	 cri.setPerPageNum(10);;
	 cri.setKeyword("test");
	 cri.setSearchType("ALL");

		logger.info("=====================================");

		List<BoardVO> list = dao.listSearch(cri);

		for (BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + ": " + boardVO.getTitle());
		}

		logger.info("=====================================");

		logger.info("COUNT: " + dao.listSearchCount(cri));
	}

}
