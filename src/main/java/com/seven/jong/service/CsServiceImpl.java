package com.seven.jong.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.seven.jong.DTO.FaqDTO;
import com.seven.jong.DTO.MessageDTO;
import com.seven.jong.DTO.QnaDTO;
import com.seven.jong.DTO.QnaRepDTO;
import com.seven.jong.VO.UserVO;
import com.seven.jong.repository.ICsMapper;

@Service
public class CsServiceImpl implements CsService{

	@Autowired ICsMapper mapper;
	
	@Override
	public ArrayList<FaqDTO> faq(Model model) {
		ArrayList<FaqDTO> faqList = mapper.faqList();
		model.addAttribute("faqList", faqList);
		return null;
	}

	@Override
	public void addFaq(FaqDTO dto) {
		mapper.addFaq(dto);
		
	}

	@Override
	public void delFaq(int faqNum) {
		mapper.delFaq(faqNum);
	}

	//QnA 모든 정보
	@Override
	public ArrayList<QnaDTO> qna(int pageNum, Model model) {
		
		int allCount = mapper.selectQnaCount(); // 총 qna수 얻어오기
		int pageLetter = 3; //한 페이지에 3개의 qna 표현
		int totalPage = allCount /pageLetter; //총 페이지
		if(allCount % pageLetter != 0) {
			totalPage += 1;
		}
		int end = pageNum * pageLetter;
		int start = end + 1 - pageLetter;
	
		ArrayList<QnaDTO> qnaList = mapper.pageQnaInfo(start,end);
	
		model.addAttribute("allPage", totalPage);
		model.addAttribute("qnaList", qnaList);
		return null;
	}

	//QnA 저장
	@Override
	public void qnaSave(QnaDTO dto, MultipartHttpServletRequest mul, HttpServletRequest request) {
		//MultipartHttpServletRequest mul, 
		
		MultipartFile file = mul.getFile("imageFileName");
		
		QnaFileService qfs = new QnaFileServiceImpl();
		
		if( file.isEmpty() ) { // 파일이 비워있으면 true
			dto.setImageFileName("nan");
		}else { //파일이 존재하는 경우
			dto.setImageFileName( qfs.saveFile(file) );
		}
		
		mapper.qnaSave(dto);
		
	}
	
	//QnA 컨텐츠 보기
	@Override
	public void qnaContentView(int qnaNo, Model model) {
		model.addAttribute("qnaData", mapper.qnaContentView(qnaNo));
		upHit(qnaNo);
	}
	private void upHit(int qnaNo) {
		mapper.upHit(qnaNo);
	}

	//QnA 삭제하기
	@Override
	public String qnaDelete(int qnaNo, String imageFileName, HttpServletRequest request) {
		QnaFileService qfs = new QnaFileServiceImpl();
		int result = mapper.qnaDelete(qnaNo);
		
		MessageDTO dto = new MessageDTO();
		
		if(result == 1) {//DB삭제 성공
			qfs.deleteImage(imageFileName);
		}
		dto.setRequest(request);
		dto.setResult(result);
		dto.setSuccessMessage("성공적으로 삭제 되었습니다");
		dto.setSuccessURL("/admin/customerqna");
		dto.setFailMessage("삭제 중 문제가 발생하였습니다");
		dto.setFailURL("/admin/qnaView");
		
		return qfs.getMessage(dto);
	}

	//QnA 수정
	@Override
	public String modify(MultipartHttpServletRequest mul, HttpServletRequest request) {
		QnaDTO dto = new QnaDTO();
		dto.setQnaNo(Integer.parseInt(mul.getParameter("qnaNo")));
		dto.setTitle(mul.getParameter("title"));
		dto.setContent(mul.getParameter("content"));
		
		MultipartFile file = mul.getFile("imageFileName");
		QnaFileService bfs = new QnaFileServiceImpl();
		
		if( file.isEmpty() ) { // 이미지 변경 되지 않았음
			dto.setImageFileName(mul.getParameter("originFileName"));
		}else { // 이미지 변경 되었음.
			dto.setImageFileName(bfs.saveFile(file));
			bfs.deleteImage(mul.getParameter("originFileName"));
		}
		int result = mapper.modify(dto);
		
		MessageDTO mDto = new MessageDTO();
		mDto.setResult(result);
		mDto.setRequest(request);
		mDto.setSuccessMessage("성공적으로 수정되었습니다");
		mDto.setSuccessURL("/admin/customerqna");
		mDto.setFailMessage("수정 중 문제 발생!!!");
		mDto.setFailURL("/admin/qnaView");
		
		return bfs.getMessage(mDto);
	}

	//QnA리플 추가
	@Override
	public void addReply(QnaRepDTO dto) {
		mapper.addReply(dto);
	}

	//qna 리플 가져오기
	@Override
	public ArrayList<QnaRepDTO> getRepList(int write_group) {
//		ArrayList<QnaRepDTO> list = mapper.getRepList(write_group);
//		QnaRepDTO dto = list.get(0);
//		System.out.println(dto.getEmail());
		return mapper.getRepList(write_group);
	}

}
