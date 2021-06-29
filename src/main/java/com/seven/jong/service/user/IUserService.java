package com.seven.jong.service.user;

import com.seven.jong.DTO.user.UserRequestDTO;
import com.seven.jong.VO.UserVO;
import com.seven.jong.VO.security.UserSecurityVO;

import java.util.List;

public interface IUserService {

    void addUser(UserRequestDTO user);

    void updateUser(UserVO user);

    UserVO getUserById(Integer UserId);

    void deleteUser(UserVO user);

    List<UserVO> getUsers();
}
