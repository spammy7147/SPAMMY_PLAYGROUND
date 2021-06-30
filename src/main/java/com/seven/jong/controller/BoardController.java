package com.seven.jong.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.seven.jong.DTO.BoardDTO;
import com.seven.jong.VO.UserVO;
import com.seven.jong.VO.security.UserSecurityVO;
import com.seven.jong.service.BoardFileService;
import com.seven.jong.service.BoardService;



@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired 
	BoardService bs;
	
	//boardAllList.jsp연결
	@GetMapping("/boardalllist")
	public String boardAllList(Model model, @RequestParam(value="pageNum", required = false, defaultValue = "1") int pageNum) {
		System.out.println("boardAllList연결");
		bs.boardAllList(model,pageNum);
		return "board/boardAllList";
	}
	//writeForm.jsp 연결
	@GetMapping("/writeform")
	public String writeForm(@Nullable Authentication authentication, Model model) {
		UserSecurityVO userSecurityVO = (UserSecurityVO) authentication.getPrincipal();
		UserVO userVO = userSecurityVO.getUser();
		model.addAttribute("loginUser", userVO.getEmail());
		return "board/writeForm";
	}
	//게시물 저장
	@PostMapping("/writeSave")
	public String writeSave(BoardDTO dto, HttpServletRequest request, MultipartHttpServletRequest mtfRequest, HttpServletResponse response) throws IOException {
		bs.writeSave(dto, request, mtfRequest);
		
	   
		return "redirect:/board/boardalllist";
	}
	//선택 게시물 보기 , 리플 가져오기
	@GetMapping("contentview")
	public String contentView (@Nullable Authentication authentication, @RequestParam int writeNo, Model model) {
		bs.contentView(writeNo, model);
		
		UserSecurityVO userSecurityVO = (UserSecurityVO) authentication.getPrincipal();
		UserVO userVO = userSecurityVO.getUser();
		model.addAttribute("loginUser", userVO.getEmail());
		
		return "board/contentView";
	}
	//이미지 불러오기
	@GetMapping("boarddownload")
	public void downLoad(@RequestParam String fileName,
						HttpServletResponse response) throws Exception{
		response.addHeader("Content-disposition","attachment;fileName"+fileName);
		File file = new File(BoardFileService.Board_IMAGE_REPO+"/"+fileName);
		FileInputStream in = new FileInputStream(file);
			
		System.out.println(file);
			
		FileCopyUtils.copy(in, response.getOutputStream());
		in.close();
	}
	
	//modifyForm 연결
	@GetMapping("boardmodifyform")
	public String modifyForm(@RequestParam int writeNo, Model model) {
		bs.contentView(writeNo, model);
		return "board/modifyForm";
	}
	//게시물 수정
	@PostMapping("boardmodify")
	public void modify(BoardDTO dto, HttpServletRequest request, MultipartHttpServletRequest mul, HttpServletResponse response) throws IOException {
		String message = bs.boardModify(dto, request, mul);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(message);
	}
	//게시물 삭제
	@GetMapping("boarddelete")
	public void delete(@RequestParam int writeNo, @RequestParam String fileName,
			HttpServletResponse response, HttpServletRequest request) throws IOException {
		String message = bs.boardDelete(writeNo,fileName,request);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(message);
	}
	//게시물 검색
	@PostMapping("/boardSearch")
	public String boardSearch(@RequestParam(value="num" , required=false, defaultValue="1") int num, @RequestParam("choice")String choice, @RequestParam("boardSearch")String search, Model model) {
		System.out.println("boardSearch연결");

		bs.boardSearch(num, choice ,search,model);
		return "board/boardSearch";
	}
	//댓글 추가
	@PostMapping("addreply")
	public String addReply(@RequestParam String content,@RequestParam int writeNo, @RequestParam String writer){//세션 추가해야함
		System.out.println(writer);
		System.out.println(writeNo);
		bs.addReply(content,writeNo,writer);	
		return "redirect:contentview?writeNo="+writeNo;
	}
	//댓글 삭제
	@GetMapping("replydelete")
	public String replyDelete(@RequestParam int writeNo, @RequestParam int reply_num) {
		bs.replyDelete(reply_num);
		return "redirect:contentview?writeNo="+writeNo;
	}
	//댓글 수정창 이동
	@GetMapping("boardmodifyreplyform")
	public String modifyReplyForm(@RequestParam int reply_num, @RequestParam int writeNo ,Model model) {
		bs.selectReply(model, reply_num, writeNo);
		return "board/modifyReplyForm";
	}
	//댓글 수정
	@PostMapping("boardmodifyreply")
	public String modifyReply(@RequestParam int writeNo,@RequestParam String content,@RequestParam int reply_num) {
		bs.modifyReply(content,reply_num);
		System.out.println(content);
		return "redirect:/board/contentview?writeNo="+writeNo;
	}

}
















