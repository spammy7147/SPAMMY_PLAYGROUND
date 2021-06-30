package com.seven.jong.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.seven.jong.DTO.BoardDTO;
import com.seven.jong.DTO.BoardReplyDTO;
import com.seven.jong.DTO.MessageDTO;
import com.seven.jong.repository.IBoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	IBoardMapper mapper;
	
	@Override
	public void writeSave(BoardDTO dto, HttpServletRequest request, MultipartHttpServletRequest mtfRequest) {
		MultipartFile file = mtfRequest.getFile("imageFileName");
		
		BoardFileService bfs = new BoardFileServiceImpl();
		
		if( file.isEmpty() ) { // 파일이 비워있으면 true
			dto.setFileName("nan");
		}else { //파일이 존재하는 경우
			dto.setFileName( bfs.saveFile(file) );
		}
		
		mapper.writeSave(dto);
	}

	@Override
	public void boardAllList(Model model,int num) {
		int allCount = mapper.BoardCount();
		int pageLetter = 10;
		int repeat = allCount / pageLetter;
		
		if(allCount % pageLetter != 0) {
			repeat += 1;
		}
		
		int end = num * pageLetter;
		int start = end + 1 - pageLetter;
		model.addAttribute("repeat", repeat);		
		model.addAttribute("boardList",mapper.boardAllList(start,end));
		
	}

	@Override
	public void contentView(int writeNo, Model model) {
		
		model.addAttribute("contentData",mapper.contentView(writeNo));
		model.addAttribute("replyList",mapper.getReplyList(writeNo));
		upHit(writeNo);
	}
	private void upHit(int writeNo) {
		mapper.upHit(writeNo);
	}

	@Override
	public String modify(BoardDTO dto, HttpServletRequest request, MultipartHttpServletRequest mul) {
		
		MultipartFile file = mul.getFile("newFileName");
		BoardFileService bfs = new BoardFileServiceImpl();
		
		if(file.isEmpty() ) { // 이미지 변경 되지 않았음
			dto.setFileName(mul.getParameter("originFileName"));
		}else { // 이미지 변경 되었음.
			dto.setFileName(bfs.saveFile(file));
			bfs.deleteImage(mul.getParameter("originFileName"));
		}
		int result = mapper.modify(dto);
		
		MessageDTO mDto = new MessageDTO();
		mDto.setResult(result);
		mDto.setRequest(request);
		mDto.setSuccessMessage("성공적으로 수정되었습니다");
		mDto.setSuccessURL("/admin/boardalllist");
		mDto.setFailMessage("수정 중 문제 발생!!!");
		mDto.setFailURL("/admin/contentview");
		
		return bfs.getMessage(mDto);
	}

	@Override
	public String delete(int writeNo, String fileName, HttpServletRequest request) {
		BoardFileService bfs = new BoardFileServiceImpl();
		int result = mapper.delete(writeNo);
		
		MessageDTO dto = new MessageDTO();
		
		if(result == 1) {//DB삭제 성공
			bfs.deleteImage(fileName);
		}
		dto.setRequest(request);
		dto.setResult(result);
		dto.setSuccessMessage("성공적으로 삭제 되었습니다");
		dto.setSuccessURL("/admin/boardalllist");
		dto.setFailMessage("삭제 중 문제가 발생하였습니다");
		dto.setFailURL("/admin/contentview");
		
		return bfs.getMessage(dto);
	}
	
	@Override
	public String boardDelete(int writeNo, String fileName, HttpServletRequest request) {
		BoardFileService bfs = new BoardFileServiceImpl();
		int result = mapper.delete(writeNo);
		
		MessageDTO dto = new MessageDTO();
		
		if(result == 1) {//DB삭제 성공
			bfs.deleteImage(fileName);
		}
		dto.setRequest(request);
		dto.setResult(result);
		dto.setSuccessMessage("성공적으로 삭제 되었습니다");
		dto.setSuccessURL("/board/boardalllist");
		dto.setFailMessage("삭제 중 문제가 발생하였습니다");
		dto.setFailURL("/board/contentView");
		
		return bfs.getMessage(dto);
	}

	@Override
	public void boardSearch(int num, String choice, String search, Model model) {
		
		String c = null;
		if(choice.equals("1")) {
			c = "title";
		}else {
			c = "writer";
		}
		
		System.out.println(num);
		System.out.println(c);
		System.out.println(search);
				
		int allCount = mapper.selectBoardCount(search,c);
		int pageLetter = 10;
		int repeat = allCount / pageLetter;
		
		if(allCount % pageLetter != 0) {
			repeat += 1;
		}
		int end = num * pageLetter;
		int start = end + 1 - pageLetter;
	
		model.addAttribute("repeat", repeat);	
		model.addAttribute("searchList", mapper.boardSearchList(start,end,c,search));
		
	}

	@Override
	public List<BoardReplyDTO> getReplyList(int write_group) {
		
		return mapper.getReplyList(write_group);
	}

	@Override
	public void addReply(String content, int writeNo,String writer) {
		mapper.addReply(content, writeNo, writer);
		
	}

	@Override
	public void replyDelete(int reply_num) {
		mapper.replyDelete(reply_num);
		
	}


	@Override
	public void selectReply(Model model, int reply_num, int writeNo) {
		model.addAttribute("replyData",mapper.selectReply(reply_num));
		model.addAttribute("writeNo",writeNo);
	}

	@Override
	public void modifyReply(String content, int reply_num) {

		mapper.modifyReply(content,reply_num);
		
	}

	


	





	

	

}
