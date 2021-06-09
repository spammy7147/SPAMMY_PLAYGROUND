package com.seven.jong.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    private Integer member_id;
    private String email;
    private String password;
    private String name;
    private String birth;
    private String phone;
    private String regdate;
    private Integer hosting_id;
}
