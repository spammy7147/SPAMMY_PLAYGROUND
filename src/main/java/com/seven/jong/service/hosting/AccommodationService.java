package com.seven.jong.service.hosting;

import com.seven.jong.DTO.common.PageDTO;
import com.seven.jong.DTO.common.SearchDTO;
import com.seven.jong.DTO.hosting.AccommodationAddressRequestDTO;
import com.seven.jong.DTO.hosting.AccommodationHouseRequestDTO;
import com.seven.jong.DTO.hosting.AccommodationInfoResponseDTO;
import com.seven.jong.VO.hosting.AccommodationPhotoVO;
import com.seven.jong.VO.hosting.AccommodationTempVO;
import com.seven.jong.VO.hosting.AccommodationVO;
import com.seven.jong.VO.security.UserSecurityVO;
import com.seven.jong.repository.hosting.IAccommodationMapper;
import com.seven.jong.repository.hosting.IAccommodationPhotoMapper;
import com.seven.jong.service.FilePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccommodationService implements IAccommodationService {

    IAccommodationMapper accommodationMapper;
    IAccommodationPhotoMapper accommodationPhotoMapper;
    FilePath filePath;

    @Autowired
    public void setFilePath(FilePath filePath) {
        this.filePath = filePath;
    }
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
    public List<AccommodationVO> getAllByUserId(Authentication authentication, PageDTO pageDTO) {
        pageDTO.setUserId(((UserSecurityVO)authentication.getPrincipal()).getUser().getUserId());
        return accommodationMapper.getAllByUserId(pageDTO);
    }

    @Override
    public AccommodationInfoResponseDTO getOneById(Integer accommodationId) {
        AccommodationVO accommodationVO = accommodationMapper.getOneById(accommodationId);
        List<String> url = new ArrayList<>();
        accommodationPhotoMapper.getPhotos(accommodationId).forEach(s -> url.add(s.getPhotoURL()));

        AccommodationInfoResponseDTO accommodationInfoResponseDTO = new AccommodationInfoResponseDTO();
        accommodationInfoResponseDTO.setAccommodationId(accommodationVO.getAccommodationId());
        accommodationInfoResponseDTO.setUserId(accommodationVO.getUserId());
        accommodationInfoResponseDTO.setName(accommodationVO.getName());
        accommodationInfoResponseDTO.setAddress(accommodationVO.getAddress());
        accommodationInfoResponseDTO.setType(accommodationVO.getType());
        accommodationInfoResponseDTO.setPrice(accommodationVO.getPrice());
        accommodationInfoResponseDTO.setMaxNumberOfGuest(accommodationVO.getMaxNumberOfGuest());
        accommodationInfoResponseDTO.setNumberOfBedroom(accommodationVO.getNumberOfBedroom());
        accommodationInfoResponseDTO.setNumberOfBed(accommodationVO.getNumberOfBed());
        accommodationInfoResponseDTO.setNumberOfBathroom(accommodationVO.getNumberOfBathroom());
        accommodationInfoResponseDTO.setContactNumber(accommodationVO.getContactNumber());
        accommodationInfoResponseDTO.setDescription(accommodationVO.getDescription());
        accommodationInfoResponseDTO.setRegDate(accommodationVO.getRegDate());
        accommodationInfoResponseDTO.setPhotoURL(url);

        return accommodationInfoResponseDTO;
    }

    @Override
    public void getPhoto(Integer accommodationId, String url, HttpServletResponse response) {

        if(url == null || url.equals("")){
            String one = "";
            try{
                one= accommodationPhotoMapper.getPhotos(accommodationId).get(0).getPhotoURL();
            }catch (Exception e){
                System.out.println("등록된 사진없음!");
                return;
            }
            response.addHeader("Content-disposition","attachment;fileName"+one);
            try {
                FileCopyUtils.copy(new FileInputStream(filePath.getPath()+ one), response.getOutputStream());
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(filePath.getPath()+one);
        }else{
            response.addHeader("Content-disposition","attachment;fileName"+url);
            try {
                FileCopyUtils.copy(new FileInputStream(filePath.getPath()+ url), response.getOutputStream());
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(filePath.getPath()+url);
        }


    }

    @Override
    public boolean deleteAccommodation(Integer accommodationId, Authentication authentication) {
        if(accommodationMapper.getOneById(accommodationId).getUserId().equals(((UserSecurityVO) authentication.getPrincipal()).getUser().getUserId()) || authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
                accommodationMapper.deleteAccommodation(accommodationId);
                return true;
        }
        return false;
    }

    @Override
    public Integer getNumberAccommodationByUserId(Integer userId) {
        return accommodationMapper.getNumberAccommodationByUserId(userId);
    }

    @Override
    public void updateAddress(AccommodationAddressRequestDTO accommodationAddressRequestDTO, Integer accommodationId) {


        accommodationMapper.updateAddress(
                AccommodationVO.builder()
                        .accommodationId(accommodationId)
                        .address(accommodationAddressRequestDTO.getCountry()
                                + accommodationAddressRequestDTO.getCity()
                                + accommodationAddressRequestDTO.getDistrict()
                                + accommodationAddressRequestDTO.getRoad()
                                + accommodationAddressRequestDTO.getRoom()
                        )
                        .build());
    }

    @Override
    public void updateHouse(AccommodationHouseRequestDTO accommodationHouseRequestDTO, Integer accommodationId) {
        accommodationMapper.updateHouse(
                AccommodationVO.builder()
                .accommodationId(accommodationId)
                .name(accommodationHouseRequestDTO.getName())
                .type(accommodationHouseRequestDTO.getType())
                .maxNumberOfGuest(accommodationHouseRequestDTO.getMaxNumberOfGuest())
                .numberOfBedroom(accommodationHouseRequestDTO.getNumberOfBedroom())
                .numberOfBed(accommodationHouseRequestDTO.getNumberOfBed())
                .numberOfBathroom(accommodationHouseRequestDTO.getNumberOfBathroom())
                .price(accommodationHouseRequestDTO.getPrice())
                .contactNumber(accommodationHouseRequestDTO.getContactNumber())
                .description(accommodationHouseRequestDTO.getDescription())
                .build()
        );
    }

    @Override
    public List<AccommodationVO> searchAccommodation(SearchDTO searchDTO) {
        return accommodationMapper.searchAccommodation(searchDTO);
    }

    @Override
    public Integer countSearch(SearchDTO searchDTO) {
        return accommodationMapper.countSearch(searchDTO);
    }


}
