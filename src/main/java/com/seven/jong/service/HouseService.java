package com.seven.jong.service;


import org.springframework.ui.Model;


public interface HouseService {
	//숙소 수
	public int numberOfHouse();
	
	//숙소 리스트
	public void houseList(int pageNum, Model model);

	//숙소 검색
	public void houseSearch(int pageNum, String c, String search, Model model);

	//숙소 삭제
	public int houseDelete(int accommodationId);

}
