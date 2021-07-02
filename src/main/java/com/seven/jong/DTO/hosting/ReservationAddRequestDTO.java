package com.seven.jong.DTO.hosting;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class ReservationAddRequestDTO {

    private Integer accommodationId;
    private Integer numberOfGuest;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
}
