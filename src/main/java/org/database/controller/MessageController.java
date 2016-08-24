package org.database.controller;

import javax.inject.Inject;

import org.database.domain.MessageVO;
import org.database.domain.UserVO;
import org.database.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {
	
	@Inject
	private MessageService service;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<String> addMessage(@RequestBody MessageVO vo){
		
		ResponseEntity<String>	entity = null;
		try{
			service.addMessage(vo);
			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/{mid}", method = RequestMethod.PUT)
	public ResponseEntity<MessageVO> readMessage(@PathVariable("mid") Integer mid, @RequestBody UserVO vo){
		
		ResponseEntity<MessageVO>	entity = null;
		try{
			entity = new ResponseEntity<>(service.readMessage(vo.getUser_id(), mid), HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
