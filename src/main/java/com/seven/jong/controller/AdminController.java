package com.seven.jong.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.seven.jong.DTO.FaqDTO;
import com.seven.jong.DTO.UserRequestDTO;
import com.seven.jong.service.AdminUserService;
import com.seven.jong.service.CsService;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired AdminUserService aus;
	@Autowired CsService cs;
	
	//가입 유저 관리
	@GetMapping("/usermanage")
	public String userManage(@RequestParam(value="pageNum" , required=false, defaultValue="1") int pageNum, Model model) {
		aus.pageUserInfo(pageNum, model);
		return "admin/user/userManage";
	}
	//특정 유저 정보 페이지
	@GetMapping("/user/userInfo")
	public String userInfo01(@RequestParam("userId") int userId, Model model) {
		aus.info(userId, model);
		return "admin/user/userInfo";
	}
	//유저정보 수정
	@PostMapping("/user/modifyUserInfo")
	public String modifyUserInfo(@RequestParam("userId") int userId, UserRequestDTO user, Model model) { ///유저아이디, 등등
		aus.modifyUser(userId,user);
		return "redirect:userInfo?userId="+userId;
	}
	//유저검색
	@PostMapping("/user/usersearch")
	public String userSearch(@RequestParam(value="pageNum" , required=false, defaultValue="1") int pageNum, @RequestParam("choice")String choice, @RequestParam("userSearch")String search, Model model) {
		String c = null;
		if(choice.equals("1")) {
			c = "email";
		}else {
			c = "name";
		}
		
		aus.userSearch(pageNum, c,search,model);
		return "admin/user/userSearch";
	}
	
	
	
	//등록된 숙소 관리
	@GetMapping("/housemanage")
	public String houseManage() {
		return "admin/house/houseManage";
	}
	// 숙소 검색
	@PostMapping("/house/housesearch")
	public String houseSearch() {
		
		return "admin/house/houseSearch";
	}
	
	
	
	
	
	
	//예약 관리
	@GetMapping("/bookingmanage")
	public String bookingManage() { 
		return "admin/booking/bookingManage";
	}
	
	@GetMapping("/board")
	public String board() {
		return "board/boardAllList";
	}
	

	
}
