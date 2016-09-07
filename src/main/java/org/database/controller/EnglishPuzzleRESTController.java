package org.database.controller;

import java.util.List;

import javax.inject.Inject;

import org.database.domain.PuzzleVO;
import org.database.service.PuzzleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/puzzle")
public class EnglishPuzzleRESTController {
	@Inject
	private PuzzleService service;
	
	@RequestMapping(value = "/getPuzzle", method = RequestMethod.GET)
	public ResponseEntity<List<PuzzleVO>> getPuzzle(){
		ResponseEntity<List<PuzzleVO>> entity = null;
		try {
			entity = new ResponseEntity<List<PuzzleVO>>(service.getPuzzle(),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
