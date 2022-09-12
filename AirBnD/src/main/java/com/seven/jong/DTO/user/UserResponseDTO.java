package com.seven.jong.DTO.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class UserResponseDTO {
    private Integer userId;
    private String email;
    private String password;
    private String name;
    private LocalDate birth;
    private Integer phone;
    private LocalDateTime regDate;
    

}
