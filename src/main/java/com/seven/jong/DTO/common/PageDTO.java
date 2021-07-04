package com.seven.jong.DTO.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PageDTO {

    private Integer page;
    private Integer userId;
    private Integer reservationId;
    private Integer accommodationId;
    private Integer countPerPage =  10;

    public void setCountPerPage(Integer countPerPage) {
        this.countPerPage = countPerPage;
    }

    public PageDTO() {
        this.page = 1;
    }

    public Integer getFirstPage() {
        return (countPerPage*(this.page -1))+1;
    }
    public Integer getLastPage() {
        return page*countPerPage;
    }
    public void setPage(Integer page) {
        if(page <= 0) {
            this.page = 1;
            return;
        }
        this.page = page;
    }
}
