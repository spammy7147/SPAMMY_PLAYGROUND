package com.seven.jong.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.seven.jong.DTO.FaqDTO;
import com.seven.jong.DTO.QnaDTO;
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

	//QnA 컨텐츠 보기
	@Override
	public void qnaContentView(int qnaNo, Model model) {
		model.addAttribute("qnaData", mapper.qnaContentView(qnaNo));
		upHit(qnaNo);
	}
	private void upHit(int qnaNo) {
		mapper.upHit(qnaNo);
	}

	//QnA 저장
	@Override
	public void qnaSave(QnaDTO dto, HttpServletRequest request) {
		//MultipartHttpServletRequest mul, 
		
//		MultipartFile file = mul.getFile("imageFileName");
//		
//		QnaFileService qfs = new QnaFileServiceImpl();
//		
//		if( file.isEmpty() ) { // 파일이 비워있으면 true
//			dto.setImageFileName("nan");
//		}else { //파일이 존재하는 경우
//			dto.setImageFileName( qfs.saveFile(file) );
//		}
		
		mapper.qnaSave(dto);
		
	}

}
