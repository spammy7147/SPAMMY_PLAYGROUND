package spammy.eve.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spammy.eve.domain.Blueprint;
import spammy.eve.domain.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

}