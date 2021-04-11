package com.spring.wow.board.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.wow.user.model.UserVO;
import com.spring.wow.user.repository.IUserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class UserMapperTest {
	
	@Autowired
	private IUserMapper mapper;
	
	
	
	@Test
	public void registerTest() {
		UserVO user = new UserVO();
		user.setAccount("abcd12");
		user.setPassword("qwer12");
		user.setName("홍길동");
		
		mapper.register(user);
		System.out.println("회원가입 성공");
		
	}
	
	@Test
	public void deleteTest() {
		mapper.delete("aaa12");
		System.out.println("탈퇴 성공!");
	}

}
