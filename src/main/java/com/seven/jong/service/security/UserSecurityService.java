package com.seven.jong.service.security;

import com.seven.jong.VO.RoleVO;
import com.seven.jong.VO.UserVO;
import com.seven.jong.VO.security.IUserSecurityVO;
import com.seven.jong.VO.security.UserSecurityVO;
import com.seven.jong.repository.IRoleMapper;
import com.seven.jong.repository.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSecurityService implements IUserSecurityService {

    private IUserMapper userMapper;
    private IRoleMapper roleMapper;

    @Autowired
    public void setUserMapper(IUserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Autowired
    public void setRoleMapper(IRoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public UserSecurityVO loadUserByEmail(String email) throws UsernameNotFoundException {
        System.out.println("UserSecurityService 의 loadUserByEmail 호출");

        UserVO userVO = userMapper.getUserByEmail(email);
        return getUserSecurityVO(userVO);
    }

    public UserSecurityVO loadUserById(Integer userId) throws UsernameNotFoundException {
        System.out.println("UserSecurityService 의 loadUserById 호출");

        UserVO userVO = userMapper.getUserById(userId);
        return getUserSecurityVO(userVO);
    }

    private UserSecurityVO getUserSecurityVO(UserVO userVO) {
        List<RoleVO> roleVO = roleMapper.getRole(userVO.getUserId());
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleVO role : roleVO){
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        UserSecurityVO userSecurityVO = new UserSecurityVO();
        userSecurityVO.setUser(userVO);
        userSecurityVO.setAuthorities(authorities);

        return userSecurityVO;
    }
}
