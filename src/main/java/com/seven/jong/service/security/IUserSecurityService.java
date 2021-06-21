package com.seven.jong.service.security;

import com.seven.jong.VO.security.IUserSecurityVO;
import com.seven.jong.VO.security.UserSecurityVO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IUserSecurityService {

    UserSecurityVO loadUserByEmail(String email);

    UserSecurityVO loadUserById(Integer userId);

}
