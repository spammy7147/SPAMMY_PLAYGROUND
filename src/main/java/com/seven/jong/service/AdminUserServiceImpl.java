package com.seven.jong.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.seven.jong.VO.UserVO;
import com.seven.jong.repository.IUserMapper;

@Service
public class AdminUserServiceImpl implements AdminUserService {
	@Autowired IUserMapper mapper;
	
	public void userInfo(Model model) {
		ArrayList<UserVO> list = mapper.userInfo();
		model.addAttribute("userList", list);
	}
	
	public void info(int member_id, Model model) {
		model.addAttribute("userInfo",mapper.info(member_id)) ;
	}
	
}
