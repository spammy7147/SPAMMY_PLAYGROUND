package com.seven.jong.service.hosting;

import com.seven.jong.DTO.hosting.ReservationAddRequestDTO;
import com.seven.jong.DTO.hosting.ReservationDTO;
import com.seven.jong.VO.hosting.AccommodationVO;
import com.seven.jong.VO.hosting.ReservationVO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

public interface IReservationService {

    void addReservation(ReservationAddRequestDTO reservationAddRequestDTO, Authentication authentication);

    void updateReservation(ReservationAddRequestDTO reservationAddRequestDTO, Authentication authentication);

    ReservationVO getReservationById(Integer reservationId);

    ReservationVO getReservationByUser(Integer UserId);

    List<ReservationVO> getAllReservations();

    void deleteReservationWithId(Integer reservationId);

    void deleteReservationWithUser(Integer userId);

    //총 예약 수 가져오기
    public int numberOfReservation();
    
    //예약정보 리스트 가져오기
    void reservationList(int pageNum, Model model);

    //예약정보 검색
	void bookingSearch(int pageNum, String c, String search, Model model);
}
