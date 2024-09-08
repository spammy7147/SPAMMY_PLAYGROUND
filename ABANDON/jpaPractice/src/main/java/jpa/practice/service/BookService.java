package jpa.practice.service;

import jpa.practice.domain.Book;
import jpa.practice.repository.AuthorRepository;
import jpa.practice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final AuthorService authorService;


    @Transactional(propagation = Propagation.REQUIRED)
    public void putBookAndAuthor() {
        Book book = new Book();
        book.setName("JPA 공부중!!!!!");
        bookRepository.save(book);
        try{
        authorService.putAuthor();
        }catch(Exception e) {
        }

//        throw new RuntimeException("오류 발생! commit이 진행되지 않습니다! (transactional) 상황에서만!");

    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void get(long id) {
        System.out.println(">>> " + bookRepository.findById(id));
        System.out.println(">>> " + bookRepository.findAll());

        System.out.println(">>> " + bookRepository.findById(id));
        System.out.println(">>> " + bookRepository.findAll());

        bookRepository.update();
//        Book book = bookRepository.findById(id).get();
//        book.setName("바뀔까?");
//        bookRepository.save(book);
    }
}
