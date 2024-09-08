package com.seven.jong.repository.hosting;

import com.seven.jong.VO.hosting.AccommodationVO;
import com.seven.jong.VO.hosting.ReservationVO;
import com.seven.jong.VO.security.UserSecurityVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class IReservationMapperTest {

    @Autowired
    IReservationMapper reservationMapper;


    @Test
    public void addReservationTest(){
        for (int j = 0; j < 100; j++){
            reservationMapper.addReservation(
                    ReservationVO.builder()
                            .accommodationId(61)
                            .userId(1)
                            .checkIn(LocalDate.now())
                            .checkOut(LocalDate.now())
                            .numberOfGuest(j)
                            .build()
            );
        }

    }
}