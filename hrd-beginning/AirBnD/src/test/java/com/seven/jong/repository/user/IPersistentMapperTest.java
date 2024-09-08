package com.seven.jong.repository.user;

import com.seven.jong.VO.security.PersistentTokenVO;
import com.seven.jong.repository.user.IPersistentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class IPersistentMapperTest {

    @Autowired
    IPersistentMapper persistentMapper;

    @Test
    public void getToken(){
        PersistentTokenVO token = persistentMapper.getTokenByUserId(1);
        System.out.println(token);
    }
    @Test
    public void delToken(){
        persistentMapper.removeUserTokens(162);

    }
}