package com.seven.jong.service.hosting;

import com.seven.jong.DTO.hosting.AccommodationDTO;
import com.seven.jong.VO.hosting.AccommodationPhotoVO;
import com.seven.jong.VO.hosting.AccommodationTempVO;
import com.seven.jong.VO.hosting.AccommodationVO;
import com.seven.jong.VO.security.UserSecurityVO;
import com.seven.jong.repository.hosting.IAccommodationMapper;
import com.seven.jong.repository.hosting.IAccommodationPhotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccommodationService implements IAccommodationService {

    IAccommodationMapper accommodationMapper;
    IAccommodationPhotoMapper accommodationPhotoMapper;

    @Autowired
    public void setAccommodationMapper(IAccommodationMapper accommodationMapper) {
        this.accommodationMapper = accommodationMapper;
    }
    @Autowired
    public void setAccommodationPhotoMapper(IAccommodationPhotoMapper accommodationPhotoMapper) {
        this.accommodationPhotoMapper = accommodationPhotoMapper;
    }

    public void addAccommodation(AccommodationTempVO accommodationTempVO, List<String> photoURL){
        AccommodationVO accommodationVO = AccommodationVO.builder()
                .userId(accommodationTempVO.getUserId())
                .name(accommodationTempVO.getName())
                .address(accommodationTempVO.getAddress())
                .type(accommodationTempVO.getType())
                .maxNumberOfGuest(accommodationTempVO.getMaxNumberOfGuest())
                .numberOfBedroom(accommodationTempVO.getNumberOfBedroom())
                .numberOfBed(accommodationTempVO.getNumberOfBed())
                .numberOfBathroom(accommodationTempVO.getNumberOfBathroom())
                .price(accommodationTempVO.getPrice())
                .contactNumber(accommodationTempVO.getContactNumber())
                .description(accommodationTempVO.getDescription())
                .build();

        accommodationMapper.addAccommodation(accommodationVO);
        Integer accommodationId = accommodationMapper.findForPhoto(accommodationVO).getAccommodationId();

        for(String url : photoURL){
            accommodationPhotoMapper.addPhoto(
                    AccommodationPhotoVO.builder()
                            .accommodationId(accommodationId)
                            .photoURL(url)
                            .build()
            );
        }

    }

    @Override
    public List<AccommodationVO> getAllByUserId(Authentication authentication) {

        return accommodationMapper.getAllByUserId(((UserSecurityVO)authentication.getPrincipal()).getUser().getUserId());
    }

    @Override
    public void houseList(int pageNum, Model model) {
        int allCount = accommodationMapper.selectHouseCount(); // 총 숙소수 얻어오기
        int pageLetter = 5; //한 페이지에 표현 할 개수
        int totalPage = allCount /pageLetter; //총 페이지
        if(allCount % pageLetter != 0) {
            totalPage += 1;
        }
        int end = pageNum * pageLetter;
        int start = end + 1 - pageLetter;

        ArrayList<AccommodationDTO> houseList = accommodationMapper.houseList(start,end);

        model.addAttribute("allPage", totalPage);
        model.addAttribute("houseList", houseList);

    }

}
