package jpabook.jpashop.repository.order.simplequery;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.repository.OrderSimpleQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderSimpleQueryRepository {

    private final EntityManager em;

    public List<jpabook.jpashop.repository.OrderSimpleQueryDto> findOrderDtos() {
        return em.createQuery("select new jpabook.jpashop.repository.OrderSimpleQueryDto(o.id, m.name, o.orderDate, o.status, d.address) " +
                                "from orders o " +
                                "join o.member m " +
                                "join o.delivery d",
                        OrderSimpleQueryDto.class)
                .getResultList();
    }
}
