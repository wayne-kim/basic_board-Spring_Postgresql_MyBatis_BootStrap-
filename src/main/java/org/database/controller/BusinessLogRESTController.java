package org.database.controller;

import java.util.List;

import javax.inject.Inject;

import org.database.domain.BusinessLogVO;
import org.database.domain.UserVO;
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

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<BusinessLogVO>> getTodayLogs() {
		ResponseEntity<List<BusinessLogVO>> entity = null;
		try {
			entity = new ResponseEntity<List<BusinessLogVO>>(service.todayBusinessLogs(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody BusinessLogVO vo) {
		ResponseEntity<String> entity = null;
		try {
			service.createBusinessLog(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "{lno}", method = RequestMethod.PUT)
	public ResponseEntity<String> update(@PathVariable("lno") Integer lno, @RequestBody BusinessLogVO vo) {
		ResponseEntity<String> entity = null;
		try {
			vo.setLno(lno);
			service.updateBusinessLog(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "{lno}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("lno") Integer lno, @RequestBody BusinessLogVO vo) {
		ResponseEntity<String> entity = null;
		try {
			vo.setLno(lno);
			service.deleteBusinessLog(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
