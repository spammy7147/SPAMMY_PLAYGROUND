package jpa.practice.domain;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void test(){
        User user = new User();
        user.setId(1L);
        user.setName("홍길동");

        System.out.println(user.toString());
    }



}