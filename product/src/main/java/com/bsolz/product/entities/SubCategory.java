package com.bsolz.product.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubCategory extends AbstractEntity {

    @Column(length = 150)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(columnDefinition = "TEXT")
    private String description;


    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "subCategory")
    private Set<SubCategoryChild> subCategoryChildSet;
}
