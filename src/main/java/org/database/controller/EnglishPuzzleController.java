package org.database.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.database.domain.BusinessLogVO;
import org.database.domain.PuzzleVO;
import org.database.service.PuzzleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles requests for the application home page.
 */

@Controller
@RequestMapping("/game")
public class EnglishPuzzleController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/englishPuzzle", method = RequestMethod.GET)
	public void englishPuzzel(Locale locale, Model model){
		
	}
}