package com.seven.jong.service.hosting;

import com.seven.jong.DTO.hosting.AccommodationAddressRequestDTO;
import com.seven.jong.DTO.hosting.AccommodationDTO;
import com.seven.jong.VO.hosting.AccommodationTempVO;
import com.seven.jong.VO.hosting.AccommodationVO;
import com.seven.jong.VO.security.UserSecurityVO;
import com.seven.jong.repository.hosting.IAccommodationMapper;
import com.seven.jong.repository.hosting.IAccommodationTempMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import java.util.List;

public class AccommodationTempService implements IAccommodationTempService {

    IAccommodationTempMapper accommodationTempMapper;

    @Autowired
    public void setAccommodationTempMapper(IAccommodationTempMapper accommodationTempMapper) {
        this.accommodationTempMapper = accommodationTempMapper;
    }

    @Override
    public void addAddress(AccommodationAddressRequestDTO accommodationAddressRequestDTO, Authentication authentication) {

        accommodationTempMapper.addAddress(
                AccommodationTempVO.builder()
                        .address( accommodationAddressRequestDTO.getCountry()
                                + accommodationAddressRequestDTO.getCity()
                                + accommodationAddressRequestDTO.getDistrict()
                                + accommodationAddressRequestDTO.getRoad()
                                + accommodationAddressRequestDTO.getRoom()
                        )
                        .userId(((UserSecurityVO)authentication.getPrincipal()).getUser().getUserId())
                        .build()
        );
    }
    @Override
    public void addHouse(AccommodationDTO accommodationDTO) {
        accommodationTempMapper.addHouse(AccommodationTempVO.builder().build());
    }

    @Override
    public void updateAccommodation(AccommodationDTO accommodationDTO) {

    }

    @Override
    public AccommodationVO getAccommodationById(Integer accommodationId) {
        return null;
    }

    @Override
    public AccommodationVO getAccommodationByName(String name) {
        return null;
    }

    @Override
    public List<AccommodationVO> getAllAccommodations() {
        return null;
    }

    @Override
    public void deleteAccommodation(Integer accommodationId) {

    }
}
