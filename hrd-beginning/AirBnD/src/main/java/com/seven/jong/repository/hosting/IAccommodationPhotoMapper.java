package com.seven.jong.repository.hosting;

import com.seven.jong.VO.hosting.AccommodationPhotoVO;
import com.seven.jong.VO.hosting.AccommodationVO;

import java.util.List;

public interface IAccommodationPhotoMapper {

    void addPhoto(AccommodationPhotoVO accommodationPhotoVO);

    List<AccommodationPhotoVO> getPhotos(Integer accommodationId);

}
