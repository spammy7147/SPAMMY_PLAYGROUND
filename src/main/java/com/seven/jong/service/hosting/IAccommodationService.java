package com.seven.jong.service.hosting;

import com.seven.jong.VO.hosting.AccommodationTempVO;
import com.seven.jong.VO.hosting.AccommodationVO;
import org.springframework.ui.Model;

import java.util.List;

public interface IAccommodationService {

    void addAccommodation(AccommodationTempVO accommodationTempVO, List<String> photoURL);

    //숙소 리스트
    public void houseList(int pageNum, Model model);
}
