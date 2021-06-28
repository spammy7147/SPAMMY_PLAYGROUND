package com.seven.jong.service;

import org.springframework.ui.Model;

import com.seven.jong.DTO.user.UserRequestDTO;

public interface AdminUserService {
	
	public void pageUserInfo(int pageNum, Model model);
	
	public void info(int userId, Model model);
	
	void modifyUser(int userId, UserRequestDTO user);

	public void userSearch( int pageNum, String c, String search, Model model);
	
}
