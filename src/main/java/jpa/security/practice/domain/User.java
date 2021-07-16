package jpa.security.practice.domain;

import jpa.security.practice.domain.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@EntityListeners(value = {AuditingEntityListener.class, UserEntityListener.class})
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    private String email;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city", column =@Column(name="home_city")),
            @AttributeOverride(name="district", column =@Column(name="home_district")),
            @AttributeOverride(name="detail", column =@Column(name="home_address_detail")),
            @AttributeOverride(name="zipCode", column =@Column(name="home_zip_code"))
    })
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city", column =@Column(name="company_city")),
            @AttributeOverride(name="district", column =@Column(name="company_district")),
            @AttributeOverride(name="detail", column =@Column(name="company_address_detail")),
            @AttributeOverride(name="zipCode", column =@Column(name="company_zip_code"))
    })
    private Address companyAddress;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    @ToString.Exclude
    private List<UserHistory> userHistories = new ArrayList<>();

    @OneToMany
    @JoinColumn(name="user_id")
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();


}
