package com.seven.jong.DTO.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


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
