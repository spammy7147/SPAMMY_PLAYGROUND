package com.seven.jong.repository.hosting;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seven.jong.DTO.hosting.AccommodationDTO;
import com.seven.jong.VO.hosting.AccommodationVO;

public interface IAccommodationMapper {
	
    void addAccommodation(AccommodationVO accommodation);
	AccommodationVO findForPhoto(AccommodationVO accommodationVO);
	List<AccommodationVO> getAllByUserId(Integer userId);

    // 총 숙소 수 가져오기
 	public int selectHouseCount();

 	// 숙소 리스트 가져오기
 	ArrayList<AccommodationDTO> houseList(@Param("s") int start, @Param("e") int end);

	
}
