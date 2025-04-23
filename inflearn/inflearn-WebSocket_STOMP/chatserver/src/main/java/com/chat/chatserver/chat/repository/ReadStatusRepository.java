package com.chat.chatserver.chat.repository;

import com.chat.chatserver.chat.domain.ReadStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadStatusRepository extends JpaRepository<ReadStatus, Long> {

}
