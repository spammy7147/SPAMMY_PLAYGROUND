package com.seven.jong.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.seven.jong.DTO.BoardDTO;
import com.seven.jong.DTO.user.UserRequestDTO;

public interface AdminUserService {
	//총 유저수
	public int numberOfUser();
	
	public void pageUserInfo(int pageNum, Model model);
	
	public void info(int userId, Model model);
	
	void modifyUser(int userId, UserRequestDTO user);

	public void userSearch( int pageNum, String c, String search, Model model);
	
}
