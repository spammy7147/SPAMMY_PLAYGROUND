package com.seven.jong.service.user;

import com.seven.jong.DTO.user.UserRequestDTO;
import com.seven.jong.VO.RoleVO;
import com.seven.jong.VO.UserVO;
import com.seven.jong.VO.security.UserSecurityVO;
import com.seven.jong.repository.user.IRoleMapper;
import com.seven.jong.repository.user.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {


    IUserMapper userMapper;
    IRoleMapper roleMapper;
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public void setUserMapper(IUserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Autowired
    public void setRoleMapper(IRoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }
    @Autowired
    public void setBCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void addUser(UserRequestDTO userRequestDTO) {

        List<Integer> birth = new ArrayList<>();
        for (String date:userRequestDTO.getBirth().split("-")) {
            birth.add(Integer.parseInt(date));
        }

        UserVO user  =  UserVO.builder()
                    .email(userRequestDTO.getEmail())
                    .password(bCryptPasswordEncoder.encode(userRequestDTO.getPassword()))
                    .name(userRequestDTO.getName())
                    .phone(userRequestDTO.getPhone())
                    .birth(LocalDate.of(birth.get(0),birth.get(1),birth.get(2)))
                    .isAccountLocked(false)
                    .build();
        userMapper.addUser(user); //사용자 추가

        roleMapper.addRole(RoleVO.builder()
                .userId(userMapper.getUserByEmail(userRequestDTO.getEmail()).getUserId())
                .role("ROLE_USER")
                .build());  // 사용자 권한(user) 추가
    }

    @Override
    public void deleteUser(UserVO userVO) {
        Integer userId = userVO.getUserId();
        userMapper.deleteUser(userId);
    }

    @Override
    public void updateUser(UserVO userVO) {
        UserVO updateUser =
                UserVO.builder()
                .userId(userVO.getUserId())
                .email(userVO.getEmail())
                .name(userVO.getName())
                .phone(userVO.getPhone())
                .isAccountLocked(false)
                .build();
        userMapper.updateUser(updateUser);
    }

    @Override
    public UserVO getUserById(Integer userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public List<UserVO> getUsers() {
        return userMapper.getUsers();
    }
}
