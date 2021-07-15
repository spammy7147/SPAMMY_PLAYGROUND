package jpa.security.practice.domain;


import jpa.security.practice.domain.converter.BookStatusConverter;
import jpa.security.practice.repository.dto.BookStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@EntityListeners(value = AuditingEntityListener.class)
@Where(clause = "deleted=false")
public class Book extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String category;
    private Long authorId;
//    private Long publisherId;

    @OneToOne(mappedBy = "book")
    @ToString.Exclude
    private BookReviewInfo bookReviewInfo;

    @OneToMany
    @JoinColumn(name="book_id")
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @ToString.Exclude
    private Publisher publisher;

//    @ManyToMany
    @OneToMany
    @JoinColumn(name="book_id")
    @ToString.Exclude
    private List<BookAndAuthor> bookAndAuthors = new ArrayList<>();

    private boolean deleted;

//    @Convert(converter = BookStatusConverter.class)
    private BookStatus status; //판매상태

    public void addBookAndAuthors(BookAndAuthor... bookAndAuthors){
        Collections.addAll(this.bookAndAuthors,bookAndAuthors);
    }
}
