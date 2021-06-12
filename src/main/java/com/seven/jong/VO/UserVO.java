package com.seven.jong.VO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import oracle.sql.DATE;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
public class UserVO {

    private Integer userId;
    private String email;
    private String password;
    private String name;
    private LocalDate birth;
    private Integer phone;
    private LocalDateTime regdate;

}
