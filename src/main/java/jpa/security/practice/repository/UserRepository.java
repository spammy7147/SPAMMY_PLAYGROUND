package jpa.security.practice.repository;

import jpa.security.practice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

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

    List<User> findFirst2ByName(String name);

    List<User> findTop3ByName(String name);

    List<User> findByNameAndId(Long id, String name);






}
