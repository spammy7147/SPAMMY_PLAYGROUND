package com.seven.jong.repository.hosting;

import com.seven.jong.VO.hosting.AccommodationVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class IAccommodationMapperTest {

    @Autowired
    IAccommodationMapper accommodationMapper;

    @Test
    public void addAccommodationTest(){
        for (int j = 0; j < 100; j++){
            AccommodationVO accommodationVO =
                    AccommodationVO.builder()
                            .userId(1)
                            .address("서울어딘가")
                            .name("소맥킹")
                            .type("아파트")
                            .price(j)
                            .maxNumberOfGuest(j)
                            .numberOfBathroom(j)
                            .numberOfBedroom(j)
                            .numberOfBed(j)
                            .contactNumber(j)
                            .description("머물기 좋은곳")
                            .build();
            accommodationMapper.addAccommodation(accommodationVO);
        }

    }
}