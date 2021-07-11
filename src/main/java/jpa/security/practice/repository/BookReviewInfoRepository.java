package jpa.security.practice.repository;

import jpa.security.practice.domain.BookReviewInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReviewInfoRepository extends JpaRepository<BookReviewInfo,Long> {
}
