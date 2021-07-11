package jpa.security.practice.repository;

import jpa.security.practice.domain.Book;
import jpa.security.practice.domain.Publisher;
import jpa.security.practice.domain.Review;
import jpa.security.practice.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void bookTest() {
        Book book = new Book();
        book.setName("JPA Entity Listener");
        book.setAuthorId(1L);
//        book.setPublisherId(1L);

        bookRepository.save(book);
        System.out.println(bookRepository.findAll());
    }


    @Test
    @Transactional
    void BookRelationTest() {
        givenBookAndReview();

        User user = userRepository.findAll().get(0);
        System.out.println("Review : " + user.getReviews());
        System.out.println("Book : " + user.getReviews().get(0).getBook());
        System.out.println("Publisher : " + user.getReviews().get(0).getBook().getPublisher());

    }

    private void givenBookAndReview() {
        givenReview(givenUser(), givenBook(givenPublisher()));
    }
    private User givenUser() {
        return userRepository.findById(1L).orElseThrow(RuntimeException::new);
    }
    private void givenReview(User user, Book book) {
        Review review = new Review();
        review.setTitle("JPA 공부중!");
        review.setContent("재미있당");
        review.setScore(5.0f);
        review.setUser(user);
        review.setBook(book);

        reviewRepository.save(review);
    }

    private Book givenBook(Publisher publisher) {
        Book book = new Book();
        book.setName("JPA 공부중입니다.");
        book.setPublisher(publisher);

        return bookRepository.save(book);
    }
    private Publisher givenPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("인텔리제이!!");

        return publisherRepository.save(publisher);
    }
}
