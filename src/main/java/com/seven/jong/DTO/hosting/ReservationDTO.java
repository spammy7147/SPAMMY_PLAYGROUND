package com.seven.jong.DTO.hosting;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;



@Getter
@Setter
@ToString
public class ReservationDTO {

    private Integer reservationId;
    private Integer userId;
    private Integer hostingId;
    private Integer numberOfGuest;
    private LocalDateTime start;
    private LocalDateTime end;

}
