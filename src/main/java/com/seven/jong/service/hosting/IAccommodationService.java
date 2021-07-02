package com.seven.jong.service.hosting;

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

    List<AccommodationVO> getAllByUserId(Authentication authentication);

    void getPhoto(Integer accommodationId,String url, HttpServletResponse response);

    //숙소 리스트
    public void houseList(int pageNum, Model model);
}
