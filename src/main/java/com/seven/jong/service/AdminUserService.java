package com.seven.jong.service;

import org.springframework.ui.Model;

import com.seven.jong.DTO.UserRequestDTO;

public interface AdminUserService {
	
	public void pageUserInfo(int start, Model model);
	
	public void info(int userId, Model model);
	
	void modifyUser(int userId, UserRequestDTO user);
	
}
