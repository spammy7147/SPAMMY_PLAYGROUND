package com.seven.jong.service.hosting;

import com.seven.jong.DTO.hosting.AccommodationDTO;
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
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
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
    public List<AccommodationVO> getAllByUserId(Authentication authentication) {

        return accommodationMapper.getAllByUserId(((UserSecurityVO)authentication.getPrincipal()).getUser().getUserId());
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

        System.out.println(filePath.getPath()+url);
        response.addHeader("Content-disposition","attachment;fileName"+url);
        try {
            FileCopyUtils.copy(new FileInputStream(filePath.getPath()+ url), response.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
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
}
