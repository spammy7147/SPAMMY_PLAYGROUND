package com.seven.jong.DTO.hosting;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccommodationHouseRequestDTO {

    private String name;
    private String type;
    private Integer maxNumberOfGuest;
    private Integer numberOfBedroom;
    private Integer numberOfBed;
    private Integer numberOfBathroom;
    private Integer contactNumber;
    private Integer price;
    private String description;
}
