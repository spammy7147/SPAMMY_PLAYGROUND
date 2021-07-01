package com.seven.jong.DTO.hosting;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
