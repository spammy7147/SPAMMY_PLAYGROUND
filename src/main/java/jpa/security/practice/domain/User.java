package jpa.security.practice.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    private LocalDateTime createdAt;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

}
