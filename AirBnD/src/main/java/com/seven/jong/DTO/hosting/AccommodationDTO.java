package com.seven.jong.DTO.hosting;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class AccommodationDTO {

    private Integer accommodationId;
    private Integer userId;
    private String name;
    private String address;
    private String type;
    private Integer maxNumberOfGuest;
    private Integer numberOfBedroom;
    private Integer numberOfBed;
    private Integer numberOfBathroom;
    private Integer contactNumber;
    private Integer price;
    private String description;
    private LocalDateTime regDate;
    private List<String> photoURL;

}
