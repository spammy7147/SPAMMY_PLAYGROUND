package com.seven.jong.DTO.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SearchDTO extends PageDTO {

    private String keyword;
    private String condition;

    public SearchDTO() {
        this.keyword = "";
        this.condition ="";
    }

}
