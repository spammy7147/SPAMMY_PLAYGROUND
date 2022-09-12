package com.seven.jong.DTO.hosting;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;



@Getter
@Setter
@ToString
public class ReservationDTO {

    private Integer reservationId;
    private Integer accommodationId;
    private Integer userId;
    private Integer numberOfGuest;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private LocalDateTime regDate;

}
