package jpa.security.practice.repository;

import jpa.security.practice.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void bookTest() {
        Book book = new Book();
        book.setName("JPA Entity Listener");
        book.setAuthor("spammy7147");

        bookRepository.save(book);
        System.out.println(bookRepository.findAll());
    }

}
