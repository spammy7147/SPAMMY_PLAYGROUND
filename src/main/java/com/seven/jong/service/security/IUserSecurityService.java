package com.seven.jong.service.security;

import com.seven.jong.VO.security.IUserSecurityVO;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IUserSecurityService {

    IUserSecurityVO loadUserByEmail(String var1) throws UsernameNotFoundException;


}
