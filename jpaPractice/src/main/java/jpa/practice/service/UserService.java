package jpa.practice.service;

import jpa.practice.domain.User;
import jpa.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class UserService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void put() {
        User user = new User();
        user.setName("spammy7147");
        user.setEmail("spammy7147@gmail.com");

        entityManager.persist(user);
//        entityManager.detach(user);

        user.setName("spammyAfterPersist");
        entityManager.merge(user);
//        entityManager.flush();
//        entityManager.clear();

//        entityManager.remove(user);

        User user1 = userRepository.findById(1L).get();
        entityManager.remove(user1);

        user1.setName("spammy0000");
        entityManager.persist(user1);
    }
}
