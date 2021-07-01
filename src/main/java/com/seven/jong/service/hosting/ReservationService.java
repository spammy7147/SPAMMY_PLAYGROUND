package com.seven.jong.service.hosting;

import com.seven.jong.DTO.QnaDTO;
import com.seven.jong.DTO.hosting.ReservationAdminDTO;
import com.seven.jong.DTO.hosting.ReservationDTO;
import com.seven.jong.VO.hosting.ReservationVO;
import com.seven.jong.repository.hosting.IReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
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
    
    @Override
	public void reservationList(int pageNum, Model model) {
    	int allCount = reservationMapper.reservationCount(); // 총 예약수 얻어오기
		int pageLetter = 10; //한 페이지에 표현 할 갯수
		int totalPage = allCount /pageLetter; //총 페이지
		if(allCount % pageLetter != 0) {
			totalPage += 1;
		}
		int end = pageNum * pageLetter;
		int start = end + 1 - pageLetter;
	
		ArrayList<ReservationAdminDTO> reservationList = reservationMapper.reservationList(start,end);		
	
		model.addAttribute("allPage", totalPage);
		model.addAttribute("reservationList", reservationList);
		
	}
}
