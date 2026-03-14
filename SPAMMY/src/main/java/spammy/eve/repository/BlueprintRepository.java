package spammy.eve.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spammy.eve.domain.Blueprint;

@Repository
public interface BlueprintRepository extends JpaRepository<Blueprint, Integer> {

}