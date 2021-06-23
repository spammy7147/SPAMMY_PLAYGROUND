package com.seven.jong.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.seven.jong.DTO.FaqDTO;
import com.seven.jong.DTO.QnaDTO;
import com.seven.jong.DTO.QnaRepDTO;

public interface CsService {

	ArrayList<FaqDTO> faq(Model model);

	void addFaq(FaqDTO dto);

	void delFaq(int faqNum);

	ArrayList<QnaDTO> qna(int pageNum, Model model);

	//qna 저장
	void qnaSave(QnaDTO dto, MultipartHttpServletRequest mul, HttpServletRequest request);
	
	//선택 qna 가져오기
	void qnaContentView(int qnaNo, Model model);

	//qna 삭제하기
	String qnaDelete(int qnaNo, String imageFileName, HttpServletRequest request);

	//qna 수정
	String modify(MultipartHttpServletRequest mul, HttpServletRequest request);

	//qna 리플 추가
	void addReply(QnaRepDTO dto);

	//qna 리플 가져오기
	ArrayList<QnaRepDTO> getRepList(int write_group);


}
