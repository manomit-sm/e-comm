package com.bsolz.product.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Data
public abstract class AbstractEntity {

    @Id
    // Before Hibernate 6
    // @GeneratedValue(generator = "uuid")
    // @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    // @Type(type = "org.hibernate.type.UUIDCharType") // Example for character storage
    // @Column(name = "id", columnDefinition = "char(36)")

    // From Hibernate 6
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID id;

    protected LocalDateTime createdDate;

    protected LocalDateTime updateDate;

    @PrePersist
    public void beforeInsert() {
        this.createdDate = LocalDateTime.now();
    }
}
