package com.seven.jong.DTO.hosting;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Setter
@Getter
@ToString
public class ReservationAddRequestDTO {

    private Integer accommodationId;
    private Integer numberOfGuest;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkIn;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkOut;
}
