package com.seven.jong.repository.hosting;

import java.util.ArrayList;
import java.util.List;

import com.seven.jong.DTO.common.PageDTO;
import org.apache.ibatis.annotations.Param;

import com.seven.jong.DTO.hosting.ReservationAdminDTO;
import com.seven.jong.VO.hosting.ReservationVO;

public interface IReservationMapper {
	
	void addReservation(ReservationVO reservationVO);
	void updateReservation(ReservationVO reservationVO);
	void deleteReservation(Integer reservationId);
	ReservationVO getOneById(Integer reservationId);
	List<ReservationVO> getAllByUser(PageDTO pageDTO);
	Integer getNumberOfReservationByUserId(Integer userId);

	//총 예약 수 받아오기
	int reservationCount();

	//예약 정보 가져오기
	ArrayList<ReservationAdminDTO> reservationList(@Param("s")int start, @Param("e")int end);

	//검색 조건에 맞는 예약정보 수
	int SearchReservationCount(@Param("c")String c, @Param("search")String search);

	//검색 조건에 맞는 예약 정보 리스트
	ArrayList<ReservationAdminDTO> ReservationSearchList(@Param("s")int start, @Param("e")int end, @Param("c")String c, @Param("search")String search);
	
}
