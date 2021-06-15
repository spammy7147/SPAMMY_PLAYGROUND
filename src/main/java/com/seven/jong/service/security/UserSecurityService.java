package com.seven.jong.service.security;

import com.seven.jong.VO.UserVO;
import com.seven.jong.VO.security.IUserSecurityVO;
import com.seven.jong.repository.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements IUserSecurityService {

    private IUserMapper userMapper;

    @Autowired
    public void setUserMapper(IUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public IUserSecurityVO loadUserByEmail(String var1) throws UsernameNotFoundException {

        UserVO userVO = userMapper.getUser(var1);


        return null;
    }
}
