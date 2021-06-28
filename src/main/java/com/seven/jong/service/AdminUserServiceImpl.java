package com.seven.jong.service;

import com.seven.jong.DTO.user.UserRequestDTO;
import com.seven.jong.VO.UserVO;
import com.seven.jong.repository.user.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;

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
		ArrayList<UserVO> list = mapper.pageUserInfo(start,end);
	
		model.addAttribute("allPage", totalPage);
		model.addAttribute("userList", list);
	}
	
	public void info(int userId, Model model) {
		model.addAttribute("userInfo",mapper.info(userId)) ;
	}
	
	@Override
	public void modifyUser(int userId, UserRequestDTO user) {
		//요청한 userId에 해당하는 유저 정보를 user 객체의 정보로 update
		String name= user.getName();
		String birth= user.getBirth();
		int phone= user.getPhone();
	
		//System.out.println(name);
		//System.out.println(birth);
		//System.out.println(phone);
	
		mapper.updateUserInfo(userId, name, birth, phone);
	
	
	}
	
	//유저검색 (c==1:email, c==2:name)
	@Override
	public void userSearch(int pageNum, String c, String search, Model model) {
		
		int allCount = mapper.selectSearchUserCount(c,search); // 조건에 맞는 유저 수 얻어오기
		int pageLetter = 3; //한 페이지에 3명의 유저 표현
		int totalPage = allCount /pageLetter; //총 페이지
		
		if(allCount % pageLetter != 0) {
			totalPage += 1;
		}
		
		int end = pageNum * pageLetter;
		int start = end + 1 - pageLetter;
		
		//start,end,컬럼이름,검색내용
		ArrayList<UserVO> userSearchList = mapper.userSearchList(start,end,c,search);
		
		model.addAttribute("allPage", totalPage);
		model.addAttribute("userSearchList", userSearchList);
	}

	
}
