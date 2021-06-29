package com.seven.jong.service.hosting;

import com.seven.jong.VO.hosting.AccommodationVO;
import com.seven.jong.VO.hosting.ReservationVO;

import java.util.List;

public interface IReservationService {

    void addReservation(ReservationVO reservationVO);

    void updateReservation(ReservationVO reservationVO);

    ReservationVO getReservationById(Integer reservationId);

    ReservationVO getReservationByUser(Integer UserId);

    List<ReservationVO> getAllReservations();

    void deleteReservationWithId(Integer reservationId);

    void deleteReservationWithUser(Integer userId);
}
