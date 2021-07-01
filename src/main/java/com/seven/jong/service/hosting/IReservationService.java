package com.seven.jong.service.hosting;

import com.seven.jong.DTO.hosting.ReservationDTO;
import com.seven.jong.VO.hosting.AccommodationVO;
import com.seven.jong.VO.hosting.ReservationVO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

public interface IReservationService {

    void addReservation(ReservationVO reservationVO);

    void updateReservation(ReservationVO reservationVO);

    ReservationVO getReservationById(Integer reservationId);

    ReservationVO getReservationByUser(Integer UserId);

    List<ReservationVO> getAllReservations();

    void deleteReservationWithId(Integer reservationId);

    void deleteReservationWithUser(Integer userId);

    //예약정보 리스트 가져오기
    void reservationList(int pageNum, Model model);
}
