package jpa.security.practice.domain.listener;

import jpa.security.practice.domain.User;
import jpa.security.practice.domain.UserHistory;
import jpa.security.practice.repository.UserHistoryRepository;
import jpa.security.practice.support.BeanUtils;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;


public class UserEntityListener {


    @PostPersist
    @PostUpdate
    public void preUpdate(Object o) {
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);
         User user = (User)o;

         UserHistory userHistory = new UserHistory();
         userHistory.setEmail(user.getEmail());
         userHistory.setName(user.getName());
         userHistory.setUser(user);
         userHistory.setHomeAddress(user.getHomeAddress());
         userHistory.setCompanyAddress(user.getCompanyAddress());

         userHistoryRepository.save(userHistory);
    }

}
