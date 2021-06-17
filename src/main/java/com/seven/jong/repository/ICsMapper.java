package com.seven.jong.repository;

import java.util.ArrayList;

import com.seven.jong.DTO.FaqDTO;

public interface ICsMapper {
	
	//자주하는 질문 모든 정보
	public ArrayList<FaqDTO> faqList();

}
