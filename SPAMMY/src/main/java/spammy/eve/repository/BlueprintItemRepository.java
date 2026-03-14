package spammy.eve.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spammy.eve.domain.BlueprintItem;
import spammy.eve.domain.Type;

@Repository
public interface BlueprintItemRepository extends JpaRepository<BlueprintItem, Long> {

}