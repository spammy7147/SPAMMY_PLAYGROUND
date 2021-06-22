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
import com.seven.jong.repository.IBoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	IBoardMapper mapper;
	
	@Override
	public void writeSave(BoardDTO dto, HttpServletRequest request, MultipartHttpServletRequest mtfRequest) {
		dto.setTitle(request.getParameter("title"));
		dto.setWriter(request.getParameter("writer"));
		dto.setContent(request.getParameter("content"));
		
		String src = mtfRequest.getParameter("src");
        System.out.println("src value : " + src);
        MultipartFile mf = mtfRequest.getFile("file_name");

        //경로 지정
        String path = "C:\\upload\\";

        String originFileName = mf.getOriginalFilename(); // 원본 파일 명
        long fileSize = mf.getSize(); // 파일 사이즈

        String safeFile = path + System.currentTimeMillis() + originFileName;
        System.out.println("path : " + path);
        System.out.println("originFileName : " + originFileName);
        System.out.println("fileSize : " + fileSize);
        System.out.println("safeFile : " + safeFile);
        System.out.println("--------------------------");
        
        //디비에 저장될 파일 이름
        String fileName = System.currentTimeMillis() + originFileName;
        
        dto.setFileName(fileName);
        
        File file = new File(safeFile);
        //경로에 디렉토리가 없으면 만들기
        if (!file.exists()){
             file.mkdir();
        }
        try {
            mf.transferTo(file);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }

        String url = "/";
        String referer= request.getHeader("Referer");
        if(referer != null){
            url = referer;
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
	public void modify(BoardDTO dto, HttpServletRequest request, MultipartHttpServletRequest mul) {
		
		dto.setWriteNo(Integer.parseInt(request.getParameter("writeNo")));
		
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		
		MultipartFile mf = mul.getFile("newFileName");

        //경로 지정
        String path = "C:\\upload\\";

        String originFileName = mf.getOriginalFilename(); 

        String safeFile = path + System.currentTimeMillis() + originFileName;
        String fileName = System.currentTimeMillis() + originFileName;
       
        dto.setFileName(fileName);
        
        File file = new File(safeFile);
        if (!file.exists()){
             file.mkdir();
        }
        try {
            mf.transferTo(file);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        
        mapper.modify(dto);
	}

	@Override
	public void delete(int writeNo) {
		mapper.delete(writeNo);
		
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
	public void replyDelete(int replyNum) {
		mapper.replyDelete(replyNum);
		
	}

	


	





	

	

}
