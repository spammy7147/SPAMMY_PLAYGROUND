package com.seven.jong.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private int member_id;
    private String pwd;
    private String name;
    private String birth;
    private String email;
    private String phone;
    private String regdate;
    private int hosting_id;
}
