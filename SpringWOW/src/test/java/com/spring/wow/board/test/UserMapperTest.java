package com.spring.wow.board.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

	@Test
	public void loginTest() {
		String inputId = "abc1234";
		String inputPw = "qwer1234!";
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		UserVO dbData = mapper.select(inputId);
		String dbPw = dbData.getPassword();
		System.out.println("입력된 비밀번호 : " + inputPw);
		System.out.println("DB에 등록된 비밀번호 : " + dbPw);
		
		System.out.println("비밀번호 일치?? : " + inputPw.equals(dbPw));
		System.out.println("비밀번호 일치?! : " + encoder.matches(inputPw, dbPw));
	}
	
}
