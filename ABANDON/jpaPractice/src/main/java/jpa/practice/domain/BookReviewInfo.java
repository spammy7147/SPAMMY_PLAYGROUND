package jpa.practice.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper=true)
public class BookReviewInfo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(optional = false)
    private Book book;
    private float averageReviewScore;
    private int reviewCount;
}
