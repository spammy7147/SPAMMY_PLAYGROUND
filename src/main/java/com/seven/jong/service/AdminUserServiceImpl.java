package com.seven.jong.service;

import com.seven.jong.DTO.BoardDTO;
import com.seven.jong.DTO.QnaDTO;
import com.seven.jong.DTO.user.UserRequestDTO;
import com.seven.jong.VO.UserVO;
import com.seven.jong.repository.user.IUserMapper;
import com.seven.jong.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

	IUserMapper userMapper;
	IUserService userService;

	@Autowired
	public void setUserMapper(IUserMapper userMapper) {
		this.userMapper = userMapper;
	}
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	//총 유저수 가져오기
	@Override
	public int numberOfUser() {
		int num = userMapper.selectUserCount();
		return num;
	}

	public void pageUserInfo(int pageNum, Model model) {
	
		int allCount = userMapper.selectUserCount(); // 총 유저수 얻어오기
		int pageLetter = 10; //한 페이지에 표현 할 유저수
		int totalPage = allCount /pageLetter; //총 페이지
		if(allCount % pageLetter != 0) {
			totalPage += 1;
		}
		int end = pageNum * pageLetter;
		int start = end + 1 - pageLetter;
	
		//System.out.println(start);
		//System.out.println(end);
		ArrayList<UserVO> list = userMapper.pageUserInfo(start,end);
	
		model.addAttribute("allPage", totalPage);
		model.addAttribute("userList", list);
	}
	
	public void info(int userId, Model model) {
		model.addAttribute("userInfo",userService.getUserById(userId)) ;
	}
	
	@Override
	public void modifyUser(int userId, UserRequestDTO user) {
		//요청한 userId에 해당하는 유저 정보를 user 객체의 정보로 update
		String name= user.getName();
		int phone= user.getPhone();
		List<Integer> birth = new ArrayList<>();
		for (String date:user.getBirth().split("-")) {
			birth.add(Integer.parseInt(date));
		}
		UserVO updateUser = UserVO.builder()
				.name(name)
				.birth(LocalDate.of(birth.get(0),birth.get(1),birth.get(2)))
				.phone(phone)
				.email(user.getEmail())
				.build();
		userService.updateUser(updateUser);

	}
	
	//유저검색 (c==1:email, c==2:name)
	@Override
	public void userSearch(int pageNum, String c, String search, Model model) {
		
		int allCount = userMapper.selectSearchUserCount(c,search); // 조건에 맞는 유저 수 얻어오기
		int pageLetter = 10; //한 페이지에 표현 할 유저수
		int totalPage = allCount /pageLetter; //총 페이지
		
		if(allCount % pageLetter != 0) {
			totalPage += 1;
		}
		
		int end = pageNum * pageLetter;
		int start = end + 1 - pageLetter;
		
		//start,end,컬럼이름,검색내용
		ArrayList<UserVO> userSearchList = userMapper.userSearchList(start,end,c,search);
		
		model.addAttribute("allPage", totalPage);
		model.addAttribute("userSearchList", userSearchList);
	}
	

	

	
}
