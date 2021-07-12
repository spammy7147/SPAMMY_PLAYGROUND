package jpa.security.practice.repository;

import jpa.security.practice.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
public class EntityManagerTest {
    @Autowired
    EntityManager entityManager;
    @Autowired
    UserRepository userRepository;
    @Test
    void entityMangerTest() {
        entityManager.createQuery("select u from User u").getResultList().forEach(System.out::println);
    }

    @Test
    void cacheFindTest() {
//        System.out.println(userRepository.findById(1L).get());
//        System.out.println(userRepository.findById(1L).get());
//        System.out.println(userRepository.findById(1L).get());

//        System.out.println(userRepository.findByEmail("spammy7147@gmail.com"));
//        System.out.println(userRepository.findByEmail("spammy7147@gmail.com"));
//        System.out.println(userRepository.findByEmail("spammy7147@gmail.com"));

        userRepository.deleteById(1L);
    }

    @Test
    void cacheFindTest2() {
        User user = userRepository.findById(1L).get();

        System.out.println("-------------------------------------");


        user.setName("spammyyyyyyyyyyy");

        System.out.println("-------------------------------------");

        userRepository.save(user);

        System.out.println("-------------------------------------");

        user.setEmail("spammyyyyyyyyyyy@gmail.com");
        userRepository.save(user);

        userRepository.flush();


    }
}
