package org.database.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.database.domain.BusinessLogVO;
import org.database.domain.CommentVO;
import org.database.domain.Criteria;
import org.database.service.BusinessLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/businessLogREST")
public class BusinessLogRESTController {

	@Inject
	private BusinessLogService service;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<BusinessLogVO> create(@RequestBody BusinessLogVO vo) {
		ResponseEntity<BusinessLogVO> entity = null;
		try {
			service.createBusinessLog(vo);
			entity = new ResponseEntity<BusinessLogVO>(vo, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<BusinessLogVO>(vo , HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
