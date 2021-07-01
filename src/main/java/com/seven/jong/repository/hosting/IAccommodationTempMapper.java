package com.seven.jong.repository.hosting;

import com.seven.jong.VO.hosting.AccommodationTempVO;
import com.seven.jong.VO.hosting.AccommodationVO;

public interface IAccommodationTempMapper {

    Integer checkExist(Integer UserId);

    void addAddress(AccommodationTempVO accommodation);

    void updateAddress(AccommodationTempVO accommodation);

    void addHouse(AccommodationTempVO accommodation);

    AccommodationTempVO findByUserId(Integer userId);

    void deleteAccommodation(Integer userId);

}
