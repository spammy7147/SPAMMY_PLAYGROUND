package com.seven.jong.VO.security;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

// 스프링 시큐리티에서 제공하는 UserDetail 인터페이스를 그대로 가져와서 필드 이름 변경
public interface IUserSecurityVO extends Serializable {
        Collection<? extends GrantedAuthority> getAuthorities();

        String getPassword();

        String getEmail();

        boolean isAccountNonExpired();

        boolean isAccountNonLocked();

        boolean isCredentialsNonExpired();

        boolean isEnabled();


}

