package com.seven.jong.VO.hosting;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationVO {

	private Integer reservationId;
    private Integer accommodationId;
    private Integer userId;
    private Integer numberOfGuest;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private LocalDateTime regDate;

}
