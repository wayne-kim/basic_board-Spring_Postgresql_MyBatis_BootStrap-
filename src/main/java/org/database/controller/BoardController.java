package org.database.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.database.domain.BoardVO;
import org.database.service.BoardService;
//import org.database.domain.Criteria;
//import org.database.domain.PageMaker;

@Controller
@RequestMapping("/board1/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(BoardVO board, Model model) throws Exception {
		logger.info("register get ...........");
		System.out.println("register get ...........");
	}

	// @RequestMapping(value = "/register", method = RequestMethod.POST)
	// public String registPOST(BoardVO board, Model model) throws Exception {
	//
	// logger.info("regist post ...........");
	// logger.info(board.toString());
	//
	// service.regist(board);
	//
	// model.addAttribute("result", "success");
	//
	// //return "/board/success";
	// return "redirect:/board/listAll";
	// }

	@RequestMapping(value = "/registerBoard", method = RequestMethod.POST)
	public String registBoardPOST(BoardVO board,/*Model model*/ RedirectAttributes rttr) throws Exception {
		logger.info("board regist post ...........");
		logger.info(board.toString());
		
		//board.setTitle("title");
		//board.setContent("content");
		
		service.registBoard(board);

		//model.addAttribute("result","SUCCESS");
		rttr.addFlashAttribute("msg", "SUCCESS");
		//return "/board1/success";
		return "redirect:/board1/listAll";
	}

	@RequestMapping(value = "/registerComment", method = RequestMethod.POST)
	public String registCommentPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("commnet regist post ...........");
		logger.info(board.toString());
		service.registComment(board);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/board1/listAll";
	}

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("show all list......................");
		model.addAttribute("list", service.listAll());
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String removeBoard(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {
		service.remove(bno);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board1/listAll";
	}

	@RequestMapping(value = "/removeComment", method = RequestMethod.POST)
	public String removeComment(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {
		service.remove(bno);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board1/read?bno="+bno;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyBoard(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("mod Board post............");
		service.modifyBoard(board);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board1/listAll";
	}

	@RequestMapping(value = "/modifyComment", method = RequestMethod.POST)
	public String modifyComment(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("mod Comment post............");
		service.modifyComment(board);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board1/listAll";
	}

	// @RequestMapping(value = "/listCri", method = RequestMethod.GET)
	// public void listAll(Criteria cri, Model model) throws Exception {
	// logger.info("show list Page with Criteria......................");
	// model.addAttribute("list", service.listCriteria(cri));
	// }

	// @RequestMapping(value = "/listPage", method = RequestMethod.GET)
	// public void listPage(@ModelAttribute("cri") Criteria cri, Model model)
	// throws Exception {
	// logger.info(cri.toString());
	// model.addAttribute("list", service.listCriteria(cri));
	// PageMaker pageMaker = new PageMaker();
	// pageMaker.setCri(cri);
	// // pageMaker.setTotalCount(131);
	// pageMaker.setTotalCount(service.listCountCriteria(cri));
	// model.addAttribute("pageMaker", pageMaker);
	// }

	// @RequestMapping(value = "/readPage", method = RequestMethod.GET)
	// public void read(@RequestParam("bno") int bno, @ModelAttribute("cri")
	// Criteria cri, Model model) throws Exception {
	// model.addAttribute(service.read(bno));
	// }

	// @RequestMapping(value = "/removePage", method = RequestMethod.POST)
	// public String remove(@RequestParam("bno") int bno, Criteria cri,
	// RedirectAttributes rttr) throws Exception {
	// service.remove(bno);
	// rttr.addAttribute("page", cri.getPage());
	// rttr.addAttribute("perPageNum", cri.getPerPageNum());
	// rttr.addFlashAttribute("msg", "SUCCESS");
	// return "redirect:/board/listPage";
	// }

	// @RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	// public void modifyPagingGET(@RequestParam("bno") int bno,
	// @ModelAttribute("cri") Criteria cri, Model model) throws Exception {
	// model.addAttribute(service.read(bno));
	// }

}
