package jpa.practice.domain.listener;

import jpa.practice.domain.User;
import jpa.practice.repository.UserHistoryRepository;
import jpa.practice.domain.UserHistory;
import jpa.practice.support.BeanUtils;

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
