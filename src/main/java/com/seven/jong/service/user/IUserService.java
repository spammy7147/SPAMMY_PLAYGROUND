package com.seven.jong.service.user;

import com.seven.jong.DTO.UserRequestDTO;
import com.seven.jong.VO.security.UserSecurityVO;

public interface IUserService {

    void addUser(UserRequestDTO user);

    void deleteUser(UserSecurityVO userSecurityVO);

}
