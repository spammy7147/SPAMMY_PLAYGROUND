package spammy.eve.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
    name = "type",
    indexes = {
        @Index(name = "idx_type_group_id", columnList = "group_id"),
        @Index(name = "idx_type_name_en", columnList = "name_en")
    }
)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Type {

    @Id
    @Column(name = "type_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "group_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Group group;

    @Column(name = "name_en", nullable = false, length = 255)
    private String nameEn;

    @Column(name = "name_ko", length = 255)
    private String nameKo;

    @Column(name = "published", nullable = false)
    private boolean published = true;

}