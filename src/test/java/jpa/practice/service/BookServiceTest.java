package jpa.practice.service;

import jpa.practice.domain.Book;
import jpa.practice.repository.AuthorRepository;
import jpa.practice.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookServiceTest {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void transactionTest() {
        System.out.println("book : " + bookRepository.findAll());
        System.out.println("authors : " + authorRepository.findAll());

        try{
            bookService.putBookAndAuthor();
        }catch (RuntimeException e) {
            System.out.println("오류메세지 !!" + e.getMessage());
        }

        System.out.println("book : " + bookRepository.findAll());
        System.out.println("authors : " + authorRepository.findAll());
        System.out.println("디버그종료");
    }

    @Test
    void isolationTest() {
        Book book = new Book();
        book.setName("JPA 공부중");

        bookRepository.save(book);
        bookService.get(1L);

        System.out.println(">>> " + bookRepository.findAll());
    }

}