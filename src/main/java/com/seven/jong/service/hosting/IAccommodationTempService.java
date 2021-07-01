package com.seven.jong.service.hosting;

import com.seven.jong.DTO.hosting.AccommodationAddressRequestDTO;
import com.seven.jong.DTO.hosting.AccommodationDTO;
import com.seven.jong.DTO.hosting.AccommodationHouseRequestDTO;
import com.seven.jong.VO.hosting.AccommodationTempVO;
import com.seven.jong.VO.hosting.AccommodationVO;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface IAccommodationTempService {

    void addAddress(AccommodationAddressRequestDTO accommodationAddressRequestDTO, Authentication authentication);
    void addHouse(AccommodationHouseRequestDTO accommodationHouseRequestDTO, Authentication authentication);


    AccommodationTempVO findByUserId(Authentication authentication);
    void updateAccommodation(AccommodationHouseRequestDTO accommodationHouseRequestDTO);

    AccommodationVO getAccommodationById(Integer accommodationId);

    AccommodationVO getAccommodationByName(String name);

    List<AccommodationVO> getAllAccommodations();

    void deleteAccommodation(Integer accommodationId);

}
