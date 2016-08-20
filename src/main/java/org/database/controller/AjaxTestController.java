package org.database.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AjaxTestController {
	
	private static final Logger logger = LoggerFactory.getLogger(AjaxTestController.class);
	
	@RequestMapping(value = "/AjaxTest", method = RequestMethod.GET)
	public void AjaxTest() {
		
	}
	
}
