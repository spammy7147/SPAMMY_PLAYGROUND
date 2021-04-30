package jpa.security.practice.repository;

import jpa.security.practice.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud(){
        userRepository.save(User.builder()
                                .name("구마적")
                                .build()
                            );

        userRepository.findAll().forEach(System.out::println);

    }

    @Test
    void exist(){
        boolean exists = userRepository.existsById(1L);

        System.out.println(exists);
    }

    @Test
    void delete(){
//        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
        userRepository.deleteById(1L);

    }


}