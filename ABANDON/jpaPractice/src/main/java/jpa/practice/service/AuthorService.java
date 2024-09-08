package jpa.practice.service;

import jpa.practice.domain.Author;
import jpa.practice.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void putAuthor() {
        Author author = new Author();
        author.setName("Spammy");
        authorRepository.save(author);
        throw new RuntimeException("오류 발생!");
    }
}
