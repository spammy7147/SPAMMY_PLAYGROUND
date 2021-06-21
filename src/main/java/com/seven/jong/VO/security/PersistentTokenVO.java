package com.seven.jong.VO.security;

import lombok.*;
import oracle.sql.TIMESTAMP;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersistentTokenVO {

    private Integer userId;
    private  String key;
    private  String token;
    private LocalDateTime lastUsed;



}
