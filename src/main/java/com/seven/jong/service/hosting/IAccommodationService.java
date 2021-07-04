package com.seven.jong.service.hosting;

import com.seven.jong.DTO.common.PageDTO;
import com.seven.jong.DTO.common.SearchDTO;
import com.seven.jong.DTO.hosting.AccommodationAddressRequestDTO;
import com.seven.jong.DTO.hosting.AccommodationHouseRequestDTO;
import com.seven.jong.DTO.hosting.AccommodationInfoResponseDTO;
import com.seven.jong.VO.hosting.AccommodationTempVO;
import com.seven.jong.VO.hosting.AccommodationVO;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IAccommodationService {

    void addAccommodation(AccommodationTempVO accommodationTempVO, List<String> photoURL);

    AccommodationInfoResponseDTO getOneById(Integer accommodationId);

    List<AccommodationVO> getAllByUserId(Authentication authentication, PageDTO pageDTO);

    Integer getNumberAccommodationByUserId(Integer userId);

    void getPhoto(Integer accommodationId,String url, HttpServletResponse response);

    boolean deleteAccommodation(Integer accommodationId, Authentication authentication);
    void updateAddress(AccommodationAddressRequestDTO accommodationAddressRequestDTO, Integer accommodationId);
    void updateHouse(AccommodationHouseRequestDTO accommodationHouseRequestDTO, Integer accommodationId);
    List<AccommodationVO> searchAccommodation(SearchDTO searchDTO);
    Integer countSearch(SearchDTO searchDTO);


}
