package org.database.test;

import javax.inject.Inject;

import org.database.domain.UserVO;
import org.database.persistence.UserDAO;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class UserDAOTest {
	
	@Inject
	private UserDAO dao;
	
	@Test
	public void testTime() throws Exception{
		System.out.println(dao.getTime());
	}
	
	/*
	@Test
	public void testInsertUser() throws Exception{
		UserVO vo = new UserVO();
		vo.setUser_id("member3");
		vo.setUser_ps("123");
		Character position_id = '4';
		vo.setPosition_id(position_id);
		
		dao.insertUser(vo);
	}
	*/
	
	@Test
	public void getUserById() throws Exception{
		System.out.println(dao.readUser("member3"));
	}
	
	@Test
	public void getUserByIAndPw() throws Exception{
		System.out.println(dao.readWithPW("member2", "123"));
	}
}
