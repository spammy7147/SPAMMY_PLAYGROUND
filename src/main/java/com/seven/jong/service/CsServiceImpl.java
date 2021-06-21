package com.seven.jong.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.seven.jong.DTO.FaqDTO;
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

}
