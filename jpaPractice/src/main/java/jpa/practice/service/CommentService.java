package jpa.practice.service;

import jpa.practice.domain.Comment;
import jpa.practice.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public void init() {
        for(int i =0; i < 10; i++) {
            Comment comment = new Comment();
            comment.setComment("최고에요" + i);
            commentRepository.save(comment);
       }
    }

    @Transactional(readOnly = true)
    public void updateSomething() {
        List<Comment> comments = commentRepository.findAll();

        for (Comment comment : comments) {
            comment.setComment("별로에요");
//            commentRepository.save(comment);
        }
    }

    @Transactional
    public void insertSomething() {
//        Comment comment = new Comment();
        Comment comment = commentRepository.findById(1L).get();
        comment.setComment("이건!");


        commentRepository.save(comment);
    }

}
