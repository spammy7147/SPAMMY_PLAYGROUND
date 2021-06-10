package com.seven.jong.VO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserVO {

    private Integer member_id;
    private String email;
    private String password;
    private String name;
    private LocalDate birth;
    private Integer phone;
    private LocalDateTime regdate;
}
