package com.seven.jong.service.hosting;

import com.seven.jong.VO.hosting.AccommodationVO;

import java.util.List;

public interface IAccommodationService {

    void addAccommodation(AccommodationVO accommodationVO);

    void updateAccommodation(AccommodationVO accommodationVO);

    AccommodationVO getAccommodationById(Integer accommodationId);

    AccommodationVO getAccommodationByName(String name);

    List<AccommodationVO> getAllAccommodations();

    void deleteAccommodation(Integer accommodationId);

}
