package com.seven.jong.service.hosting;

import com.seven.jong.DTO.common.PageDTO;
import com.seven.jong.DTO.common.SearchDTO;
import com.seven.jong.DTO.hosting.*;
import com.seven.jong.VO.hosting.AccommodationVO;
import com.seven.jong.VO.hosting.ReservationVO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

public interface IReservationService {

    void addReservation(ReservationAddRequestDTO reservationAddRequestDTO, Authentication authentication);

    void updateReservation(ReservationUpdateDTO reservationUpdateDTO, Authentication authentication);

    ReservationInfoResponseDTO getReservationById(Integer reservationId);

    List<ReservationListResponseDTO> getAllReservationsByUser(Authentication authentication, PageDTO pageDTO);

    boolean deleteReservation(Integer reservationId, Authentication authentication);


    Integer getNumberOfReservationByUserId(Integer userId);
    //총 예약 수 가져오기
    int numberOfReservation();
    
    //예약정보 리스트 가져오기
    void reservationList(int pageNum, Model model);

    //예약정보 검색
	void bookingSearch(int pageNum, String c, String search, Model model);
}
