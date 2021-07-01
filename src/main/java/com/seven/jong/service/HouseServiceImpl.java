package com.seven.jong.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.seven.jong.DTO.hosting.AccommodationDTO;
import com.seven.jong.repository.hosting.IAccommodationMapper;

@Service
public class HouseServiceImpl implements HouseService{

	@Autowired IAccommodationMapper aMapper;
	
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

}
