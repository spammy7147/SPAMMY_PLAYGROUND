package com.seven.jong.VO;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


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
    private Boolean isAccountLocked;
    private LocalDateTime regDate;


    public void deletePassword() {
        this.password = null;
    }
}