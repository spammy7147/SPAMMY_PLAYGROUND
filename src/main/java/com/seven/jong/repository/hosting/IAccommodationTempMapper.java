package com.seven.jong.repository.hosting;

import com.seven.jong.VO.hosting.AccommodationTempVO;
import com.seven.jong.VO.hosting.AccommodationVO;

public interface IAccommodationTempMapper {

    void addAddress(AccommodationTempVO accommodation);
    void addHouse(AccommodationTempVO accommodation);
}
