package spammy.eve.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "category")
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @Column(name = "category_id", nullable = false)
    private Long id;

    @Column(name = "icon_id", nullable = false)
    private Long iconId;

    @Column(name = "name_en", nullable = false, length = 255)
    private String nameEn;

    @Column(name = "name_ko", length = 255)
    private String nameKo;

    @Column(name = "published", nullable = false)
    private boolean published = true;


}