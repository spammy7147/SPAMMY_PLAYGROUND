package jpql.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.lang.annotation.Target;

@Data
@Entity
@Table(name="ORDERS")
public class Order {
    @Id @GeneratedValue
    private Long id;

    private int orderAmount;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

}
