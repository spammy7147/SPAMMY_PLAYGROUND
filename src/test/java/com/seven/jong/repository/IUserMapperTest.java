package com.seven.jong.repository;

import com.seven.jong.DTO.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class IUserMapperTest {
    @Autowired
    private IUserMapper mapper;
    @Test
    public void addUser() {
        UserDTO user1 = new UserDTO();
        user1.setEmail("spammy7147@gmail.com");
        user1.setName("홍길동");
        user1.setPassword("1234");
        mapper.addUser(user1);
        System.out.println(user1);
    }
}