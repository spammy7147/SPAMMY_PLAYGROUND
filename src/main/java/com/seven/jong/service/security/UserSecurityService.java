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
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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

        UserVO userVO = userMapper.getUserByEmail(email);
        List<RoleVO> roleVO = roleMapper.getRole(userVO.getUserId());
        List<GrantedAuthority> authorities = null;
        for (RoleVO role : roleVO){
            try{
                authorities.add(new SimpleGrantedAuthority(role.getRole()));
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("권한 없음");
            }
        }

        UserSecurityVO userSecurityVO =
                (UserSecurityVO) UserSecurityVO.builder()
                        .userId(userVO.getUserId())
                        .email(userVO.getEmail())
                        .password(userVO.getPassword())
                        .name(userVO.getName())
                        .birth(userVO.getBirth())
                        .phone(userVO.getPhone())
                        .isAccountLocked(userVO.getIsAccountLocked())
                        .regDate(userVO.getRegDate())
                        .build();

        userSecurityVO.setAuthorities(authorities);

        return userSecurityVO;
    }
}
