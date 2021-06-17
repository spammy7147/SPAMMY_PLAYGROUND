package com.seven.jong.VO.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

public interface IUserSecurityVO extends Serializable {

    Collection<? extends GrantedAuthority> getAuthorities();

}

