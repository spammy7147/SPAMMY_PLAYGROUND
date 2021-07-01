package com.seven.jong.service.hosting;

import com.seven.jong.DTO.hosting.AccommodationAddressRequestDTO;
import com.seven.jong.DTO.hosting.AccommodationHouseRequestDTO;
import com.seven.jong.VO.hosting.AccommodationTempVO;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;


public interface IAccommodationTempService {

    void addAddress(AccommodationAddressRequestDTO accommodationAddressRequestDTO, Authentication authentication);

    void addHouse(AccommodationHouseRequestDTO accommodationHouseRequestDTO, Authentication authentication);

    AccommodationTempVO findByUserId(Authentication authentication);

    void addPhoto(MultipartHttpServletRequest multipartHttpServletRequest, Authentication authentication);

    void deleteAccommodation(Integer userId);



}
