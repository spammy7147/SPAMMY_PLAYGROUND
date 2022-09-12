package jpa.practice.repository;

import jpa.practice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {
    Set<User> findByName(String name);

    User getByName(String name);

    User readByName(String name);

    User queryByName(String name);

    User searchByName(String name);

    User streamByName(String name);

    User findUserByName(String name);

    User findByEmail(String email);

    List<User> findFirst2ByName(String name);

    List<User> findTop3ByName(String name);

    List<User> findByNameAndId(String name, Long id);

    List<User> findByNameOrId(String name, long id);

    List<User> findByCreatedAtAfter(LocalDateTime yesterday);

    List<User> findByIdAfter(Long id);

    List<User> findByCreatedAtGreaterThan(LocalDateTime yesterday);

    List<User> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);

    List<User> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);

    List<User> findByIdBetween(Long id1, Long id2);

    List<User> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2);

    List<User> findByIdIsNotNull();

//    List<User> findByAddressIsNotEmpty();

    List<User> findByNameIn(List<String> names);

    List<User> findByNameStartingWith(String name);
    List<User> findByNameEndingWith(String name);
    List<User> findByNameContains(String name);

    List<User> findByNameLike(String name);





}
