package com.seven.jong.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String email;
    private String name;
    private String password;
}
