package jpa.security.practice.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    private LocalDateTime createAt;

}
