package jpa.security.practice.repository;

import jpa.security.practice.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

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
        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L,3L))); //select 절이 실행되고 entity의 유무를 확인후 삭제
        userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1L,3L))); //select 절 없이 바로 eneity의 삭제쿼리를 날리는 방법
        userRepository.deleteAllInBatch();

    }

    @Test
    void page(){
        Page<User> users = userRepository.findAll(PageRequest.of(0,3)); //zero-base paging

        System.out.println("page : " + users);
        System.out.println("totalElements : " + users.getTotalElements());
        System.out.println("totalPages : " + users.getTotalPages());
        System.out.println("numberOfElements : " + users.getNumberOfElements());
        System.out.println("sort : " + users.getSort());
        System.out.println("size : " + users.getSize());

        users.getContent().forEach(System.out::println);
    }

    @Test
    void QBE(){
//        ExampleMatcher matcher =  ExampleMatcher.matching()
//                .withIgnorePaths("id")
//                .withMatcher("name", endsWith());
//        Example<User> example = Example.of(new User("동"), matcher);

        User user = new User();
        user.setName("길");
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name",contains());
        Example<User> example  = Example.of(user,matcher);


        userRepository.findAll(example).forEach(System.out::println);
    }

}