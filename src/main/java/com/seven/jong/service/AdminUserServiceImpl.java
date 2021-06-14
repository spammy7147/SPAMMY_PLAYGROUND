package com.seven.jong.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.seven.jong.DTO.UserReponseDTO;
import com.seven.jong.DTO.UserRequestDTO;
import com.seven.jong.VO.UserVO;
import com.seven.jong.repository.IUserMapper;

@Service
public class AdminUserServiceImpl implements AdminUserService {
	@Autowired IUserMapper mapper;
	
	public void pageUserInfo(int pageNum, Model model) {
		
		int allCount = mapper.selectUserCount(); // 총 유저수 얻어오기
		int pageLetter = 3; //한 페이지에 3명의 유저 표현
		int totalPage = allCount /pageLetter; //총 페이지
		if(allCount % pageLetter != 0) {
			totalPage += 1;
		}
		int end = pageNum * pageLetter;
		int start = end + 1 - pageLetter;
		
		//System.out.println(start);
		//System.out.println(end);
		ArrayList<UserReponseDTO> list = mapper.pageUserInfo(start,end);
	
		model.addAttribute("allPage", totalPage);
		model.addAttribute("userList", list);
	}
	
	public void info(int userId, Model model) {
		model.addAttribute("userInfo",mapper.info(userId)) ;
	}
	
}
