package jpa.security.practice.domain;

import jpa.security.practice.domain.listener.Auditable;
import lombok.Data;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public class BaseEntity implements Auditable {

    @CreatedDate
    @Column(nullable = false, updatable = false, columnDefinition = "datetime(6) default now(6)")
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(nullable = false, columnDefinition = "datetime(6) default now(6)")
    private LocalDateTime updatedAt;
}
