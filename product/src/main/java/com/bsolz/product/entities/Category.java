package com.bsolz.product.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category extends AbstractEntity {

    @Column(length = 150)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "category")
    private Set<SubCategory> subCategories;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Product> products;
}
