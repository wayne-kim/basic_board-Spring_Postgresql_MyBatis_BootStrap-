package org.database.controller;

import java.util.List;

import javax.inject.Inject;

import org.database.domain.BusinessLogVO;
import org.database.service.BusinessLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/businessLogREST")
public class BusinessLogRESTController {

	@Inject
	private BusinessLogService service;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<BusinessLogVO>> read() {
		ResponseEntity<List<BusinessLogVO>> entity = null;
		try {
			entity = new ResponseEntity<List<BusinessLogVO>>(service.todayBusinessLogs(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(null , HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
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
