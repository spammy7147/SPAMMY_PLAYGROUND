package com.seven.jong.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@ToString
public class UserRequestDTO {
    private String email;
    private String password;
    private String name;
    private String birth;
    private Integer phone;

}
