package com.seven.jong.service;

import com.seven.jong.DTO.UserRequestDTO;
import com.seven.jong.VO.RoleVO;
import com.seven.jong.VO.UserVO;
import com.seven.jong.repository.IRoleMapper;
import com.seven.jong.repository.IUserMapper;
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
    public void addUser(UserRequestDTO requestDTO) {

        List<Integer> birth = new ArrayList<>();
        for (String date:requestDTO.getBirth().split("-")) {
            birth.add(Integer.parseInt(date));
        }

        UserVO user  =  UserVO.builder()
                    .email(requestDTO.getEmail())
                    .password(bCryptPasswordEncoder.encode(requestDTO.getPassword()))
                    .name(requestDTO.getName())
                    .phone(requestDTO.getPhone())
                    .birth(LocalDate.of(birth.get(0),birth.get(1),birth.get(2)))
                    .isAccountLocked(false)
                    .build();
        System.out.println(user);
        userMapper.addUser(user); //사용자 추가

        roleMapper.addRole(RoleVO.builder()
                .userId(userMapper.getUserByEmail(requestDTO.getEmail()).getUserId())
                .role("ROLE_USER")
                .build());  // 사용자 권한(user) 추가
    }
}
