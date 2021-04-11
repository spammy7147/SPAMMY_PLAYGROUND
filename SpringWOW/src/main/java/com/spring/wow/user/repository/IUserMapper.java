package com.spring.wow.user.repository;

import java.util.List;

import com.spring.wow.user.model.UserVO;


public interface IUserMapper {
	
	//회원가입 기능
	void register(UserVO user);
	
	//아이디 중복체크 기능
	Integer checkId(String account);
	
	//회원탈퇴 
	void delete(String account);
	
	//회원정보 조회
	UserVO select(String account);
	
	//회원정보 전체 조회 기능
	List<UserVO> selectAll();
}
