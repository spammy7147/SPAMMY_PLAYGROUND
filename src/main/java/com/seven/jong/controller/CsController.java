package com.seven.jong.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.seven.jong.DTO.FaqDTO;
import com.seven.jong.DTO.QnaDTO;
import com.seven.jong.DTO.QnaRepDTO;
import com.seven.jong.VO.UserVO;
import com.seven.jong.VO.security.UserSecurityVO;
import com.seven.jong.service.CsService;
import com.seven.jong.service.QnaFileService;



@Controller
@RequestMapping("cs")
public class CsController {
	@Autowired CsService cs;

	//고객센터(자주하는 질문)
	@GetMapping("/customerservice")
	public String customerService01(Model model) {
		cs.faq(model);
		return "cs/customerService";
	}	
	//FAQ(자주하는 질문)추가하기
	@PostMapping(value="/addFaq")
	public String addFaq(@RequestParam(value="title") String title, @RequestParam(value="content") String content) {
		FaqDTO dto = new FaqDTO();
		dto.setQuestion(title);
		dto.setAnswer(content);
		
		cs.addFaq(dto);
		return "redirect:customerservice";
	}
	//FAQ 질문 삭제
	@PostMapping(value="/delFaq")
	public String selFaq(@RequestParam(value="faqNum") int faqNum) {
		
		cs.delFaq(faqNum);
		return "redirect:customerservice";
	}
	
	
	//QnA연결
	@GetMapping("/customerqna")
	public String customerqna(@RequestParam(value="pageNum" , required=false, defaultValue="1") int pageNum, Model model) {
		cs.qna(pageNum,model);
		return "cs/customerQnA";
	}
	
	//QnA 글쓰기
	@GetMapping("/qnawriteform")
	public String qnawriteform(@Nullable Authentication authentication, Model model) {
		UserSecurityVO userSecurityVO = (UserSecurityVO) authentication.getPrincipal();
		UserVO userVO = userSecurityVO.getUser();
		model.addAttribute("loginUser", userVO.getEmail());
		return "cs/qnaWriteForm";
	}
	//QnA저장
	@PostMapping("qnasave")
	public String qnaSave(@RequestParam(value="email") String email, 
			@RequestParam(value="title") String title, @RequestParam(value="content") String content, 
			MultipartHttpServletRequest mul, HttpServletRequest request) throws Exception {
		// MultipartHttpServletRequest mul,
		//cs.qnaSave(dto, mul, request);
		QnaDTO dto = new QnaDTO();
		dto.setEmail(email);
		dto.setTitle(title);
		dto.setContent(content);
		
		cs.qnaSave(dto, mul, request);
		//cs.qnaSave(dto, request);
		
		return "redirect:customerqna";
	}
	
	//QnA 컨텐츠 보기
	@GetMapping("/qnaview")
	public String qnaview(@Nullable Authentication authentication, @RequestParam int qnaNo, Model model) {
		UserSecurityVO userSecurityVO = (UserSecurityVO) authentication.getPrincipal();
		UserVO userVO = userSecurityVO.getUser();
		model.addAttribute("loginUser", userVO.getEmail());
		
		cs.qnaContentView(qnaNo, model);
		return "cs/qnaView";
	}
		
	//이미지 파일 가져오기
	@GetMapping("download")
	public void downLoad(@RequestParam String imageFileName,
						HttpServletResponse response) throws Exception {
		response.addHeader("Content-disposition",
				"attachment;imageFileName="+imageFileName);
		File file = new File(QnaFileService.IMAGE_REPO+"/"+imageFileName);
		FileInputStream in = new FileInputStream(file);
		FileCopyUtils.copy(in, response.getOutputStream());
		in.close();
	}
	
	//QnA 삭제
	@GetMapping("deleteqna")
	public void qnaDelete(@RequestParam int qnaNo,
			@RequestParam String imageFileName,
			HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		String message = cs.qnaDeleteCS(qnaNo,imageFileName,request);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(message);
	}
	
	//QnA 수정 화면 연결
	@GetMapping("modifyqna")
	public String modifyqna(@RequestParam int qnaNo, Model model) {
		cs.qnaContentView(qnaNo,model);
		return "cs/modifyForm";
	}
	
	//QnA 수정
	@PostMapping("modify")
	public void modify(MultipartHttpServletRequest mul,
						HttpServletResponse response,
						HttpServletRequest request )throws Exception {
		String message = cs.modifyCs(mul, request);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(message);
	}
	
	@ResponseBody
	@PostMapping(value="addReply", produces = "application/json; charset=utf-8")
	public void addReply(@RequestBody Map<String, Object> map, @Nullable Authentication authentication) {
//		System.out.println("ajax연결!");
		UserSecurityVO userSecurityVO = (UserSecurityVO) authentication.getPrincipal();
		UserVO userVO = userSecurityVO.getUser();
		
		QnaRepDTO dto = new QnaRepDTO();
		dto.setEmail(userVO.getEmail());
		dto.setWrite_group( Integer.parseInt((String)map.get("qna_no")) );
		dto.setContent((String)map.get("content"));
		
//		System.out.println(userVO.getEmail());
//		System.out.println(Integer.parseInt((String)map.get("qna_no")));
//		System.out.println((String)map.get("content"));
		
		cs.addReply(dto);
	}
	
	@ResponseBody
	@PostMapping(value="replyData/{write_group}",produces = "application/json; charset=utf-8")
	public ArrayList<QnaRepDTO> replyData(@PathVariable int write_group){
		ArrayList<QnaRepDTO> list = cs.getRepList(write_group);
		for(QnaRepDTO dto : list) {
			System.out.println(dto.getEmail());
			System.out.println(dto.getWrite_date());
			System.out.println(dto.getContent());
		}
		return cs.getRepList(write_group);
	}
	
	
	
	
}
