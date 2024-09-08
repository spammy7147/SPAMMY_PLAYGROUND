package com.seven.jong.repository.user;

import com.seven.jong.VO.RoleVO;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public interface IRoleMapper {

    void addRole(RoleVO role);
    List<RoleVO> getRole(Integer userId);
    void deleteRole(Integer UserId);
}
