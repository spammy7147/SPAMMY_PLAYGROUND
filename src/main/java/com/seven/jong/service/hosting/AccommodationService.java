package com.seven.jong.service.hosting;

import com.seven.jong.VO.hosting.AccommodationVO;
import com.seven.jong.repository.hosting.IAccommodationMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccommodationService implements IAccommodationService{

    IAccommodationMapper accommodationMapper;
    @Autowired
    public void setAccommodationMapper(IAccommodationMapper accommodationMapper) {
        this.accommodationMapper = accommodationMapper;
    }

    @Override
    public void addAccommodation(AccommodationVO accommodationVO) {

    }

    @Override
    public void updateAccommodation(AccommodationVO accommodationVO) {

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
