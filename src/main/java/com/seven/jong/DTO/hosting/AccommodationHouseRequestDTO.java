package com.seven.jong.DTO.hosting;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccommodationHouseRequestDTO {

    private String name;
    private Integer maxNumberOfGuest;
    private Integer numberofBedroom;
    private Integer numberOfBed;
    private Integer numberOfBathroom;
}
