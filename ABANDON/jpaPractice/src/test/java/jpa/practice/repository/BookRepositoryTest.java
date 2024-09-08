package jpa.practice.repository;

import jpa.practice.domain.Book;
import jpa.practice.domain.Publisher;
import jpa.practice.domain.Review;
import jpa.practice.domain.User;
import jpa.practice.repository.dto.BookStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    void converterTest() {
        bookRepository.findAll().forEach(System.out::println);

        Book book = new Book();
        book.setName("JPA 컨버터 공부!");
        book.setStatus(new BookStatus(200));

        bookRepository.save(book);

        System.out.println(bookRepository.findRowRecord().values());
    }

    @Test
    void nativeQueryTest() {
//        bookRepository.findAll().forEach(System.out::println);
//      bookRepository.findAllCustom().forEach(System.out::println);

        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(e -> {
            e.setCategory("IT서적");
            books.add(e);
        });
        bookRepository.saveAll(books);
        bookRepository.findAll().forEach(System.out::println);

        System.out.println("affected rows: " + bookRepository.updateCategories());
        bookRepository.findAllCustom().forEach(System.out::println);
    }

    @Test
    void queryTest() {
        bookRepository.findByCategoryIsNullAndNameEqualsAndCreatedAtGreaterThanEqualAndUpdatedAtGreaterThanEqual(
                "JPA 공부중!!!"
                    ,LocalDateTime.now().minusDays(1L)
                    ,LocalDateTime.now().minusDays(1L))
                            .forEach(System.out::println);

        System.out.println("findByRecently :" + bookRepository.findByNameRecently("JPA 공부중!!!"
                ,LocalDateTime.now().minusDays(1L)
                ,LocalDateTime.now().minusDays(1L)));

        bookRepository.findBookNameAndCategory().forEach(System.out::println);

        bookRepository.findBookNameAndCategory(PageRequest.of(1,1)).forEach(bookNameAndCategory -> System.out.println(bookNameAndCategory.getName() + " : " + bookNameAndCategory.getCategory()));

        bookRepository.findBookNameAndCategory(PageRequest.of(0,1)).forEach(bookNameAndCategory -> System.out.println(bookNameAndCategory.getName() + " : " + bookNameAndCategory.getCategory()));
    }
    
    @Test
    void bookRemoveCascadeTest() {

        bookRepository.deleteById(1L);

        System.out.println("books :" + bookRepository.findAll());
        System.out.println("publishers :" + publisherRepository.findAll());

        bookRepository.findAll().forEach(book -> System.out.println(book.getPublisher()));

    }

    @Test
    void bookCascadeTest() {
        Book book = new Book();
        book.setName("JPA CASCADE 공부중!");

        Publisher publisher  = new Publisher();
        publisher.setName("인텔리제이");

        book.setPublisher(publisher);
        bookRepository.save(book);

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publisher : " + publisherRepository.findAll());

        Book book1 = bookRepository.findById(1L).get();
        book1.getPublisher().setName("이...이클립스?");

        bookRepository.save(book1);

        System.out.println("publishers : " + publisherRepository.findAll());

        Book book2 = bookRepository.findById(1L).get();
//        bookRepository.delete(book2);

        Book book3 = bookRepository.findById(1L).get();
        book3.setPublisher(null);

        bookRepository.save(book3);

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publishers : " + publisherRepository.findAll());
        System.out.println("book3-publisher" + bookRepository.findById(1L).get().getPublisher());
    }
    @Test
    void softDelete() {
        bookRepository.findAll().forEach(System.out::println);
    }


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
