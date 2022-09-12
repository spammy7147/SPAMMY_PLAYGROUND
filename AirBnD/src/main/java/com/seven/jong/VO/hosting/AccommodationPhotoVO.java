package com.seven.jong.VO.hosting;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccommodationPhotoVO {

    private Integer accommodationId;
    private String photoURL;
    private LocalDateTime regDate;


}
