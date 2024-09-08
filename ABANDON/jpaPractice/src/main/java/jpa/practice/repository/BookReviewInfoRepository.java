package jpa.practice.repository;

import jpa.practice.domain.BookReviewInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReviewInfoRepository extends JpaRepository<BookReviewInfo,Long> {
}
