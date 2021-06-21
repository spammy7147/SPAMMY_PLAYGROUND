package com.seven.jong.repository;

//import com.seven.jong.DTO.UserRequestDTO;

import com.seven.jong.VO.RoleVO;
import com.seven.jong.VO.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class IUserMapperTest {
    @Autowired
    private IUserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private IRoleMapper roleMapper;
    @Test
    public void addUser() {

        UserVO user  =  UserVO.builder()
                .email("test@gmail.com")
                .password(bCryptPasswordEncoder.encode("1234"))
                .name("홍길동")
                .phone(12345)
                .birth(LocalDate.now())
                .isAccountLocked(false)
                .build();
        userMapper.addUser(user); //사용자 추가

        roleMapper.addRole(RoleVO.builder()
                .userId(userMapper.getUserByEmail("test@gmail.com").getUserId())
                .role("ROLE_ADMIN")
                .build());  // 사용자 권한(user) 추가

        System.out.println(user);
    }

    @Test
    public void getUser(){
        UserVO user = userMapper.getUserByEmail("test@gmail.com");
        System.out.println(user.toString());
    }

    @Test
    public void test() {

        System.out.println(new Date().getTime());
        System.out.println(LocalDateTime.now());


    }
}