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
    private Integer userId;
    private Integer hostingId;
    private Integer numberOfGuest;
    private LocalDateTime start;
    private LocalDateTime end;

}
