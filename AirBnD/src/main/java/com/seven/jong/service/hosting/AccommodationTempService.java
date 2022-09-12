package com.seven.jong.service.hosting;

import com.seven.jong.DTO.hosting.AccommodationAddressRequestDTO;
import com.seven.jong.DTO.hosting.AccommodationHouseRequestDTO;
import com.seven.jong.VO.hosting.AccommodationTempVO;
import com.seven.jong.VO.security.UserSecurityVO;
import com.seven.jong.repository.hosting.IAccommodationTempMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccommodationTempService implements IAccommodationTempService {

    IAccommodationTempMapper accommodationTempMapper;
    AccommodationService accommodationService;

    @Autowired
    public void setAccommodationService(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @Autowired
    public void setAccommodationTempMapper(IAccommodationTempMapper accommodationTempMapper) {
        this.accommodationTempMapper = accommodationTempMapper;
    }

    @Override
    public void addAddress(AccommodationAddressRequestDTO accommodationAddressRequestDTO, Authentication authentication) {
        if (accommodationTempMapper.checkExist(((UserSecurityVO)authentication.getPrincipal()).getUser().getUserId()) == 0){ //만들기 시작한 숙소가 없음
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
        }else{
            accommodationTempMapper.updateAddress(
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

    }

    @Override
    public void addHouse(AccommodationHouseRequestDTO accommodationHouseRequestDTO, Authentication authentication) {

        accommodationTempMapper.addHouse(
                AccommodationTempVO.builder()
                        .userId(((UserSecurityVO)authentication.getPrincipal()).getUser().getUserId())
                        .name(accommodationHouseRequestDTO.getName())
                        .type(accommodationHouseRequestDTO.getType())
                        .maxNumberOfGuest(accommodationHouseRequestDTO.getMaxNumberOfGuest())
                        .numberOfBedroom(accommodationHouseRequestDTO.getNumberOfBedroom())
                        .numberOfBed(accommodationHouseRequestDTO.getNumberOfBed())
                        .numberOfBathroom(accommodationHouseRequestDTO.getNumberOfBathroom())
                        .price(accommodationHouseRequestDTO.getPrice())
                        .contactNumber(accommodationHouseRequestDTO.getContactNumber())
                        .description(accommodationHouseRequestDTO.getDescription())
                        .build());
    }

    @Override
    public AccommodationTempVO findByUserId(Authentication authentication) {
        return accommodationTempMapper.findByUserId(((UserSecurityVO)authentication.getPrincipal()).getUser().getUserId());
    }

    @Override
    public void addPhoto(MultipartHttpServletRequest multipartHttpServletRequest, Authentication authentication) {

        List<MultipartFile> multipartFiles = multipartHttpServletRequest.getFiles("file");
        List<String> photoURL = new ArrayList<>();
        //경로 지정
        String path = "C:\\upload/";

        for (MultipartFile multipartFile : multipartFiles) {
            String safeFile = System.currentTimeMillis() + multipartFile.getOriginalFilename();
            File file = new File(path + safeFile);
            file.mkdirs();

            try {
                multipartFile.transferTo(file);
                photoURL.add(safeFile);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("addPhoto :" + findByUserId(authentication));
        accommodationService.addAccommodation(findByUserId(authentication),photoURL);

        deleteAccommodation(((UserSecurityVO)authentication.getPrincipal()).getUser().getUserId());
    }

    @Override
    public void deleteAccommodation(Integer userId) {
        accommodationTempMapper.deleteAccommodation(userId);
    }
}
