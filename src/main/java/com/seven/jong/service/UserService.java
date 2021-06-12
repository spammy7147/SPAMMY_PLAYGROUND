package com.seven.jong.service;

import com.seven.jong.DTO.UserRequestDTO;
import com.seven.jong.VO.UserVO;
import com.seven.jong.repository.IUserMapper;
import oracle.sql.DATE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {


    IUserMapper userMapper;

    @Autowired
    public void setUserMapper(IUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void addUser(UserRequestDTO requestDTO) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

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
                    .build();

        System.out.println(user);
        userMapper.addUser(user);
    }
}
