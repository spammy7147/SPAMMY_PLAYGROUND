package jpa.security.practice.domain.listener;

import jpa.security.practice.domain.User;
import jpa.security.practice.domain.UserHistory;
import jpa.security.practice.repository.UserHistoryRepository;
import jpa.security.practice.support.BeanUtils;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;


public class UserEntityListener {


    @PrePersist
    @PreUpdate
    public void preUpdate(Object o) {
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);
         User user = (User)o;

         UserHistory userHistory = new UserHistory();
         userHistory.setUserId(user.getId());
         userHistory.setEmail(user.getEmail());
         userHistory.setName(user.getName());

         userHistoryRepository.save(userHistory);
    }

}
