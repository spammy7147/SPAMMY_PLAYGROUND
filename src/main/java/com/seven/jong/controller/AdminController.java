package com.seven.jong.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.seven.jong.service.AdminUserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired AdminUserService aus;
	
	//admin 홈
	@GetMapping("/home")
	public String admin() {
		//@RequestParam String id, HttpSession session 
		//session.setAttribute(LOGIN, id);
		return "admin/adminHome";
	}
	
	
	//가입 유저 관리
	@GetMapping("/usermanage")
	public String userManage(@RequestParam(value="pageNum" , required=false, defaultValue="1") int pageNum, Model model) {
		aus.pageUserInfo(pageNum, model);
		return "admin/user/userManage";
	}
	//특정 유저 정보 페이지
	@GetMapping("/user/userInfo")
	public String userInfo(@RequestParam("member_id") int member_id, Model model) {
		aus.info(member_id, model);
		return "admin/user/userInfo";
	}
	//유저검색
	@GetMapping("/user/usersearch")
	public String userSearch() {
		return "admin/user/userSearch";
	}
	
	
	
	//등록된 숙소 관리
	@GetMapping("/housemanage")
	public String houseManage() {
		return "admin/houseManage";
	}
	
	//예약 관리
	@GetMapping("/bookingmanage")
	public String bookingManage() { 
		return "admin/bookingManage";
	}
	
	@GetMapping("/board")
	public String board() {
		//유저들이 사용하는 board로 연결
		return "/board";
	}
	
	//고객센터(고객으로부터 온 메세지 대응)
	@GetMapping("/customerservice")
	public String customerService() {
		return "admin/customerService";
	}
	
}
