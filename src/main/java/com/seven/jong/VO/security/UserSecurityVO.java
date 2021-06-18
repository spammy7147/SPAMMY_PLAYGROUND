package com.seven.jong.VO.security;

import com.seven.jong.VO.UserVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@ToString
public class UserSecurityVO extends UserVO implements IUserSecurityVO  {

    private static final long serialVersionUID = 1L;
    private UserVO user;
    private List<GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


}

