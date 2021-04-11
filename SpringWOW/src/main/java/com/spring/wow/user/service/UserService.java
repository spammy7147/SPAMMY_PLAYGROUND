package com.spring.wow.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.wow.user.model.UserVO;
import com.spring.wow.user.repository.IUserMapper;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserMapper mapper;
	
	@Override
	public void register(UserVO user) {
		mapper.register(user);
	}

	@Override
	public Integer checkId(String account) {
		
		return mapper.checkId(account);
	}
	
	@Override
	public String login(UserVO user) {
		String result = null;
		UserVO login = null;
		login = mapper.select(user.getAccount());
		
		if(login != null) {
			if(user.getPassword().equals(login.getPassword())) {
				result = "loginSuccess";
			}else
				result = "pwFail";
		}else {
			result="idFail";
		}
		
		return result;
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
	public List<UserVO> selectAll() {
		
		return mapper.selectAll();
	}
}
