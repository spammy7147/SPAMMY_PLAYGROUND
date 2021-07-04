package com.seven.jong.repository.hosting;

import java.util.ArrayList;
import java.util.List;

import com.seven.jong.DTO.common.PageDTO;
import com.seven.jong.DTO.common.SearchDTO;
import org.apache.ibatis.annotations.Param;

import com.seven.jong.DTO.hosting.AccommodationDTO;
import com.seven.jong.VO.UserVO;
import com.seven.jong.VO.hosting.AccommodationVO;

public interface IAccommodationMapper {
	
    void addAccommodation(AccommodationVO accommodation);
	AccommodationVO findForPhoto(AccommodationVO accommodationVO);
	List<AccommodationVO> getAllByUserId(PageDTO pageDTO);
	AccommodationVO getOneById(Integer accommodationId);
	void deleteAccommodation(Integer accommodationId);
	Integer getNumberAccommodationByUserId(Integer userId);
	void updateAddress(AccommodationVO accommodationVO);
	void updateHouse(AccommodationVO accommodationVO);
	List<AccommodationVO> searchAccommodation(SearchDTO searchDTO);
	Integer countSearch(SearchDTO searchDTO);
    // 총 숙소 수 가져오기
 	public int selectHouseCount();

 	// 숙소 리스트 가져오기
 	ArrayList<AccommodationDTO> houseList(@Param("s") int start, @Param("e") int end);

 	// 조건에 맞는 숙소 수 얻어오기
 	public int selectSearchHouseCount(@Param("c")String c, @Param("search")String search);

	//검색 숙소 가져오기
 	public ArrayList<AccommodationDTO> houseSearchList(@Param("s")int start, @Param("e")int end, @Param("c")String c, @Param("search")String search);
 	
 	//숙소 삭제하기
	int houseDelete(int accommodationId);

	
}
