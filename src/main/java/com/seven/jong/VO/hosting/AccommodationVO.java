package com.seven.jong.VO.hosting;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class AccommodationVO {

    private Integer hostingId;
    private Integer userId;
    private String name;
    private String address;
    private String type;
    private Integer minimumNumberOfGuest;
    private Integer maximumNumberOfGuest;
    private Integer numberOfBed;
    private Integer numberOfBedroom;
    private Integer numberOfBathroom;
    private Integer contactNumber;
    private Integer price;


}
