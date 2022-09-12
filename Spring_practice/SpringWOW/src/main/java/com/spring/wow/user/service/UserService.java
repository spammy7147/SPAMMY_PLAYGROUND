package com.spring.wow.user.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.wow.user.model.UserVO;
import com.spring.wow.user.repository.IUserMapper;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserMapper mapper;
	
	@Override
	public void register(UserVO user) {
		
		//회원 비밀번호를 암호화 인코딩
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("암호화 전 : " + user.getPassword());
		
		//비밀번호를 암호화하여 다시 user객체에 저장
		String securePw = encoder.encode(user.getPassword());
		user.setPassword(securePw);
		
		System.out.println("암호화 후 : " + securePw);
		
		mapper.register(user);
	}

	@Override
	public Integer checkId(String account) {
		
		return mapper.checkId(account);
	}
	
	@Override
	public String login(UserVO user, HttpSession session, HttpServletResponse response) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String result = null;
		UserVO login = null;
		login = mapper.select(user.getAccount());
		
		if(login != null) {
			if(encoder.matches(user.getPassword(),login.getPassword())) {
				result = "loginSuccess";
				session.setAttribute("login", login);
				System.out.println("로그인 성공! 세션등록!");
				
				long limitTime = 60 * 60 * 24 * 90;  //90일
				
				if(user.isAutoLogin()) {
					System.out.println("자동로그인 쿠키 생성중.....");
					Cookie loginCookie = new Cookie("loginCookie",session.getId());
					loginCookie.setPath("/");
					loginCookie.setMaxAge((int)limitTime);
					response.addCookie(loginCookie);
					
					//자동 로그인 유지시간을 날짜객체로 변환
					long expireDate = System.currentTimeMillis() + (limitTime* 1000);
					Date limitDate = new Date(expireDate);
					
					user.setLimitTime(limitDate);
					user.setSessionId(session.getId());
					keepLogin(user);
					
					
				}
				
			}else
				result = "pwFail";
		}else {
			result="idFail";
		}
		
		return result;
	}
	
	
	
	@Override
	public void keepLogin(UserVO user) {
		mapper.keepLogin(user);
		
	}
	
	
	@Override
	public void delete(String account) {
		mapper.delete(account);
		
	}
	
	
	@Override
	public UserVO select(String account) {
		
		return mapper.select(account);
	}
	
	@Override
	public UserVO getUserWithSessionId(String sessionId) {
		
		return mapper.getUserWithSessionId(sessionId);
	}
	
	@Override
	public List<UserVO> selectAll() {
		
		return mapper.selectAll();
	}
}
