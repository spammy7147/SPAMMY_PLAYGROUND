package com.seven.jong.repository;

//import com.seven.jong.DTO.UserRequestDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.seven.jong.DTO.UserRequestDTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class IUserMapperTest {
    @Autowired
    private IUserMapper mapper;
    
    @Test
    public void addUser() {
        UserRequestDTO user1 = UserRequestDTO.builder()
                .email("spammy7147@gmail.com")
                .name("조영훈")
                .password("1234")
                .phone(1085928698)
                .build();
        mapper.addUser(user1);
        System.out.println(user1);
    }
}