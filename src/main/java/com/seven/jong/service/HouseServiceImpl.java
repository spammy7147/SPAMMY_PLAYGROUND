package com.seven.jong.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.seven.jong.DTO.hosting.AccommodationDTO;
import com.seven.jong.VO.UserVO;
import com.seven.jong.repository.hosting.IAccommodationMapper;

@Service
public class HouseServiceImpl implements HouseService{

	@Autowired IAccommodationMapper aMapper;
	
	//숙소 리스트
	@Override
	public void houseList(int pageNum, Model model) {
		int allCount = aMapper.selectHouseCount(); // 총 숙소수 얻어오기
		int pageLetter = 10; //한 페이지에 표현 할 개수
		int totalPage = allCount /pageLetter; //총 페이지
		if(allCount % pageLetter != 0) {
			totalPage += 1;
		}
		int end = pageNum * pageLetter;
		int start = end + 1 - pageLetter;
	
		ArrayList<AccommodationDTO> houseList = aMapper.houseList(start,end);
	
		model.addAttribute("allPage", totalPage);
		model.addAttribute("houseList", houseList);
		
	}
	
	//숙소 검색
	@Override
	public void houseSearch(int pageNum, String c, String search, Model model) {
		int allCount = aMapper.selectSearchHouseCount(c,search); // 조건에 맞는 숙소 수 얻어오기
		int pageLetter = 10; //한 페이지에 표현 할 갯수
		int totalPage = allCount /pageLetter; //총 페이지
		if(allCount % pageLetter != 0) {
			totalPage += 1;
		}
		int end = pageNum * pageLetter;
		int start = end + 1 - pageLetter;
		
		//start,end,컬럼이름,검색내용
		ArrayList<AccommodationDTO> houseSearchList = aMapper.houseSearchList(start,end,c,search);
		
		model.addAttribute("allPage", totalPage);
		model.addAttribute("houseSearchList", houseSearchList);
		
	}
	
	//숙소 삭제
	@Override
	public int houseDelete(int accommodationId) {
		int result = aMapper.houseDelete(accommodationId);
		return result;
	}
	
	
	

}
