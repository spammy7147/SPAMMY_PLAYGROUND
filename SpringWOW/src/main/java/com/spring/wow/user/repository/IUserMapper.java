package com.spring.wow.user.repository;

import java.util.List;

import com.spring.wow.user.model.UserVO;


public interface IUserMapper {
	
	//회원가입 기능
	void register(UserVO user);
	
	//아이디 중복체크 기능
	Integer checkId(String account);
	
	//자동로그인 쿠키값 DB 저장 처리
	void keepLogin(UserVO user);

	//회원탈퇴 
	void delete(String account);
	
	//회원정보 조회
	UserVO select(String account);
	
	//세션아이디를 통한 회원정보조회 
	UserVO getUserWithSessionId(String sessionId);
	
	//회원정보 전체 조회 기능
	List<UserVO> selectAll();
	
}
