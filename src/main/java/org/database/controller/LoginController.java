package org.database.controller;

import java.util.Locale;

import javax.inject.Inject;

import org.database.domain.LoginVO;
import org.database.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/login/*")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Inject
	private LoginService service;
	
	@RequestMapping(value = "/doorFront", method = RequestMethod.GET)
	public void doorFront(Locale locale, Model model) {
		logger.info("doorFront");
	}
	
	@RequestMapping(value = "/doorKnock", method = RequestMethod.POST)
	public String doorKnock(LoginVO loginVO, RedirectAttributes rttr) throws Exception {
		logger.info("doorFront");
		logger.info(loginVO.toString());
		
		service.doorKnock(loginVO);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board1/listPage";
	}
}
