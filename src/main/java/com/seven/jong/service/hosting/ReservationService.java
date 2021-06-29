package com.seven.jong.service.hosting;

import com.seven.jong.VO.hosting.ReservationVO;
import com.seven.jong.repository.hosting.IReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService implements IReservationService{

    IReservationMapper reservationMapper;
    @Autowired
    public void setReservationMapper(IReservationMapper reservationMapper) {
        this.reservationMapper = reservationMapper;
    }

    @Override
    public void addReservation(ReservationVO reservationVO) {

    }

    @Override
    public void updateReservation(ReservationVO reservationVO) {

    }

    @Override
    public ReservationVO getReservationById(Integer reservationId) {
        return null;
    }

    @Override
    public ReservationVO getReservationByUser(Integer UserId) {
        return null;
    }

    @Override
    public List<ReservationVO> getAllReservations() {
        return null;
    }

    @Override
    public void deleteReservationWithId(Integer reservationId) {

    }

    @Override
    public void deleteReservationWithUser(Integer userId) {

    }
}
