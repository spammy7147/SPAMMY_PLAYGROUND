package com.seven.jong.service.hosting;

import com.seven.jong.DTO.QnaDTO;
import com.seven.jong.DTO.hosting.AccommodationDTO;
import com.seven.jong.DTO.hosting.ReservationAddRequestDTO;
import com.seven.jong.DTO.hosting.ReservationAdminDTO;
import com.seven.jong.DTO.hosting.ReservationDTO;
import com.seven.jong.VO.hosting.ReservationVO;
import com.seven.jong.VO.security.UserSecurityVO;
import com.seven.jong.repository.hosting.IReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
    public void addReservation(ReservationAddRequestDTO reservationAddRequestDTO, Authentication authentication) {
        reservationMapper.addReservation(
                ReservationVO.builder()
                        .accommodationId(reservationAddRequestDTO.getAccommodationId())
                        .userId(((UserSecurityVO)authentication.getPrincipal()).getUser().getUserId())
                        .checkIn(reservationAddRequestDTO.getCheckIn())
                        .checkOut(reservationAddRequestDTO.getCheckOut())
                        .build()
        );

    }

    @Override
    public void updateReservation(ReservationAddRequestDTO reservationAddRequestDTO, Authentication authentication) {

    }

    @Override
    public ReservationVO getReservationById(Integer reservationId) {
        return reservationMapper.getOneById(reservationId);
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
        reservationMapper.deleteReservation(reservationId);
    }

    @Override
    public void deleteReservationWithUser(Integer userId) {

    }
    
    //총 예약 수 가져오기
    @Override
	public int numberOfReservation() {
    	int allCount = reservationMapper.reservationCount(); // 총 예약수 얻어오기
		return allCount;
	}
    
    //예약정보 리스트 가져오기
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
    
    //예약정보 검색
	@Override
	public void bookingSearch(int pageNum, String c, String search, Model model) {
		int allCount = reservationMapper.SearchReservationCount(c,search); // 조건에 맞는 숙소 수 얻어오기
		int pageLetter = 10; //한 페이지에 표현 할 갯수
		int totalPage = allCount /pageLetter; //총 페이지
		if(allCount % pageLetter != 0) {
			totalPage += 1;
		}
		int end = pageNum * pageLetter;
		int start = end + 1 - pageLetter;
		
		//start,end,컬럼이름,검색내용
		ArrayList<ReservationAdminDTO> bookingSearchList = reservationMapper.ReservationSearchList(start,end,c,search);
		
		model.addAttribute("allPage", totalPage);
		model.addAttribute("bookingSearchList", bookingSearchList);
		
	}

	
}
