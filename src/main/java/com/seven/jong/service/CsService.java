package com.seven.jong.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.seven.jong.DTO.FaqDTO;
import com.seven.jong.DTO.QnaDTO;

public interface CsService {

	ArrayList<FaqDTO> faq(Model model);

	void addFaq(FaqDTO dto);

	void delFaq(int faqNum);

	ArrayList<QnaDTO> qna(int pageNum, Model model);

	void qnaContentView(int qnaNo, Model model);

	//void qnaSave(QnaDTO dto, MultipartHttpServletRequest mul, HttpServletRequest request);

	void qnaSave(QnaDTO dto, HttpServletRequest request);

}
