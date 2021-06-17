package com.seven.jong.repository;

//import com.seven.jong.DTO.UserRequestDTO;

import com.seven.jong.VO.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class IUserMapperTest {
    @Autowired
    private IUserMapper userMapper;
    
    @Test
    public void addUser() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("admin"));
        authorities.add(new SimpleGrantedAuthority("user"));


        UserVO user  =  UserVO.builder()
                .email("test12@gmail.com")
                .password("1234")
                .name("홍길동")
                .phone(12345)
                .birth(LocalDate.now())
                .isAccountLocked(false)
                .build();

        System.out.println(user);
        userMapper.addUser(user);
    }

    @Test
    public void getUser(){
        UserVO user = userMapper.getUserByEmail("test12@gmail.com");
        System.out.println(user.toString());
    }
}