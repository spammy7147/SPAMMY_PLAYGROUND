package jpa.security.practice.service;

import jpa.security.practice.domain.Author;
import jpa.security.practice.domain.Book;
import jpa.security.practice.repository.AuthorRepository;
import jpa.security.practice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Transactional
    public void putBookAndAuthor() {
        Book book = new Book();
        book.setName("JPA 공부중!");

        bookRepository.save(book);

        Author author = new Author();
        author.setName("Spammy");
        authorRepository.save(author);
    }
}
