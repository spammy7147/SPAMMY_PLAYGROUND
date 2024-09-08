package com.seven.jong.service.hosting;

import com.seven.jong.DTO.common.PageDTO;
import com.seven.jong.DTO.common.SearchDTO;
import com.seven.jong.DTO.hosting.*;
import com.seven.jong.VO.hosting.AccommodationVO;
import com.seven.jong.VO.hosting.ReservationVO;
import com.seven.jong.VO.security.UserSecurityVO;
import com.seven.jong.repository.hosting.IAccommodationMapper;
import com.seven.jong.repository.hosting.IReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService implements IReservationService{

    IReservationMapper reservationMapper;
    IAccommodationMapper accommodationMapper;
    IAccommodationService accommodationService;
    @Autowired
    public void setReservationMapper(IReservationMapper reservationMapper) {
        this.reservationMapper = reservationMapper;
    }
    @Autowired
    public void setAccommodationMapper(IAccommodationMapper accommodationMapper) {
        this.accommodationMapper = accommodationMapper;
    }
    @Autowired
    public void setAccommodationService(IAccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @Override
    public void addReservation(ReservationAddRequestDTO reservationAddRequestDTO, Authentication authentication) {

        reservationMapper.addReservation(
                ReservationVO.builder()
                        .accommodationId(reservationAddRequestDTO.getAccommodationId())
                        .userId(((UserSecurityVO)authentication.getPrincipal()).getUser().getUserId())
                        .checkIn(reservationAddRequestDTO.getCheckIn())
                        .checkOut(reservationAddRequestDTO.getCheckOut())
                        .numberOfGuest(reservationAddRequestDTO.getNumberOfGuest())
                        .build()
        );

    }

    @Override
    public void updateReservation(ReservationUpdateDTO reservationUpdateDTO, Authentication authentication) {


        reservationMapper.updateReservation(
                ReservationVO.builder()
                        .reservationId(reservationUpdateDTO.getReservationId())
                        .numberOfGuest(reservationUpdateDTO.getNumberOfGuest())
                        .checkIn(reservationUpdateDTO.getCheckIn())
                        .checkOut(reservationUpdateDTO.getCheckOut())
                        .build()
        );
    }

    @Override
    public ReservationInfoResponseDTO getReservationById(Integer reservationId) {
        ReservationVO reservationVO = reservationMapper.getOneById(reservationId);
        ReservationInfoResponseDTO reservationInfoResponseDTO = new ReservationInfoResponseDTO();
        reservationInfoResponseDTO.setReservationId(reservationVO.getReservationId());
        reservationInfoResponseDTO.setAccommodationId(reservationVO.getAccommodationId());
        reservationInfoResponseDTO.setCheckIn(reservationVO.getCheckIn());
        reservationInfoResponseDTO.setCheckOut(reservationVO.getCheckOut());
        reservationInfoResponseDTO.setNumberOfGuest(reservationVO.getNumberOfGuest());
        reservationInfoResponseDTO.setRegDate(reservationVO.getRegDate());
        reservationInfoResponseDTO.setAccommodation(accommodationService.getOneById(reservationVO.getAccommodationId()));
        return reservationInfoResponseDTO;
    }

    @Override
    public List<ReservationListResponseDTO> getAllReservationsByUser(Authentication authentication, PageDTO pageDTO) {
        pageDTO.setUserId(((UserSecurityVO)authentication.getPrincipal()).getUser().getUserId());
        List<ReservationVO> reservationVOList = reservationMapper.getAllByUser(pageDTO);
        List<ReservationListResponseDTO> reservationListResponseDTOList = new ArrayList<>();
        reservationVOList.forEach(vo -> {
            ReservationListResponseDTO dto = new ReservationListResponseDTO();
            dto.setReservationId(vo.getReservationId());
            dto.setAccommodationId(vo.getAccommodationId());
            dto.setCheckIn(vo.getCheckIn());
            dto.setCheckOut(vo.getCheckOut());
            dto.setUserId(vo.getUserId());
            dto.setNumberOfGuest(vo.getNumberOfGuest());
            dto.setRegDate(vo.getRegDate());
            AccommodationVO accommodationVO = accommodationMapper.getOneById(vo.getAccommodationId());
            dto.setName(accommodationVO.getName());
            dto.setPrice(accommodationVO.getPrice());
            reservationListResponseDTOList.add(dto);
        });
        return reservationListResponseDTOList;
    }

    @Override
    public boolean deleteReservation(Integer reservationId, Authentication authentication) {
        if(reservationMapper.getOneById(reservationId).getUserId().equals(((UserSecurityVO) authentication.getPrincipal()).getUser().getUserId()) || authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
            reservationMapper.deleteReservation(reservationId);
            return true;
        }
        return false;
    }

    @Override
    public Integer getNumberOfReservationByUserId(Integer userId) {
        return reservationMapper.getNumberOfReservationByUserId(userId);
    }

    //총 예약 수 가져오기
    @Override
	public int numberOfReservation() {
        // 총 예약수 얻어오기
		return reservationMapper.reservationCount();
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
