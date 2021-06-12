package com.seven.jong.repository;

//import com.seven.jong.DTO.UserRequestDTO;
import com.seven.jong.VO.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.seven.jong.DTO.UserRequestDTO;

import java.time.LocalDate;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class IUserMapperTest {
    @Autowired
    private IUserMapper userMapper;
    
    @Test
    public void addUser() {
        UserVO user  =  UserVO.builder()
                .email("test@gmail.com")
                .password("1234")
                .name("홍길동")
                .phone(12345)
                .birth(LocalDate.now())
                .build();

        System.out.println(user);
        userMapper.addUser(user);
    }
}