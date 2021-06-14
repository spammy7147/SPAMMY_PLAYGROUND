package com.seven.jong.service;

import org.springframework.ui.Model;

public interface AdminUserService {
	
	public void pageUserInfo(int start, Model model);
	
	public void info(int member_id, Model model);
	
}
