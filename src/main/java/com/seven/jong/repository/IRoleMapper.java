package com.seven.jong.repository;

import com.seven.jong.VO.RoleVO;
import com.seven.jong.VO.UserVO;

import java.util.List;

public interface IRoleMapper {

    void addRole(RoleVO role);
    List<RoleVO> getRole(Integer userId);
}
