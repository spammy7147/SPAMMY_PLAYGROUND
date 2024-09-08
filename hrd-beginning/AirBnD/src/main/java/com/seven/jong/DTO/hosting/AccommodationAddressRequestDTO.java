package com.seven.jong.DTO.hosting;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AccommodationAddressRequestDTO {

    private String country;
    private String city;
    private String district;
    private String road;
    private String room;
}
