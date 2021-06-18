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
	
//	//admin 홈
//	@GetMapping("/home")
//	public String admin() {
//		//@RequestParam String id, HttpSession session 
//		//session.setAttribute(LOGIN, id);
//		return "admin/adminHome";
//	}
	
	
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
	
	//예약 관리
	@GetMapping("/bookingmanage")
	public String bookingManage() { 
		return "admin/booking/bookingManage";
	}
	
	@GetMapping("/board")
	public String board() {
		//ex : 관리자 권한 session생성후
		//유저들이 사용하는 board로 연결
		return "board/boardAllList";
	}
	
//	
//	//고객센터(자주하는 질문)
//	@GetMapping("/customerservice")
//	public String customerService01(Model model) {
//		cs.faq(model);
//		return "cs/customerService";
//	}	
//	//FAQ(자주하는 질문)추가하기
//	@PostMapping(value="/addFaq")
//	public String addFaq(@RequestParam(value="title") String title, @RequestParam(value="content") String content) {
//		FaqDTO dto = new FaqDTO();
//		dto.setQuestion(title);
//		dto.setAnswer(content);
//		
//		cs.addFaq(dto);
//		return "redirect:customerservice";
//	}
//	//FAQ 질문 삭제
//	@PostMapping(value="/delFaq")
//	public String selFaq(@RequestParam(value="faqNum") int faqNum) {
//		
//		cs.delFaq(faqNum);
//		return "redirect:customerservice";
//	}
//	//고객센터(문의하기)
//	@GetMapping("/customerqna")
//	public String customerqna() {
//		return "cs/customerQnA";
//	}
	
}
