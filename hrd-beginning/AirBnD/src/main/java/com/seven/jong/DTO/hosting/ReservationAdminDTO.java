package com.seven.jong.DTO.hosting;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ReservationAdminDTO {
	
	private Integer reservationId;
    private String name;
    private String email;
    private Integer numberOfGuest;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private LocalDateTime regDate;
	
}
