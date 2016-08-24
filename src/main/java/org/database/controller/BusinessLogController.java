package org.database.controller;


import javax.inject.Inject;

import org.database.service.BusinessLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/businessLog/*")
public class BusinessLogController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BusinessLogService service;

	
	//목록
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listGET(Model model) throws Exception {
		logger.info("list");
	}
	
	
}
