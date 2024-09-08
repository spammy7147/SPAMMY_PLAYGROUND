package com.seven.jong.DTO.hosting;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ReservationListResponseDTO {

    private Integer reservationId;
    private Integer accommodationId;
    private Integer userId;
    private Integer numberOfGuest;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String name;
    private Integer price;
    private LocalDateTime regDate;

}
