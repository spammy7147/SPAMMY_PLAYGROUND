package com.seven.jong.VO;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;



@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVO {

    private Integer userId;
    private String email;
    private String password;
    private String name;
    private LocalDate birth;
    private Integer phone;
    private LocalDateTime regDate;

}