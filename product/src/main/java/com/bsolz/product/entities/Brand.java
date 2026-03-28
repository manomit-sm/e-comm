package com.bsolz.product.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Brand extends AbstractEntity {

    @Column(length = 150)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String image;

    @Lob
    @Column(name = "image_2", columnDefinition = "bytea")
    private byte[] image_2;
}
