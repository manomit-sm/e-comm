package com.bsolz.product.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "sub_category_id")
    private SubCategory subCategory;

    @ManyToOne
    @JoinColumn(name = "sub_category_child_id")
    private SubCategoryChild subCategoryChild;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(unique = true)
    private String productType;

    @Column(name = "is_cosmetic_is_foodstuff")
    @Enumerated(EnumType.STRING)
    private ProductSubType productSubType;

    private Double deliveryFeeOverride;

    private Double commissionRate;

    private Double commissionFixed;

    @Column(length = 150)
    private String name;

    @Column(length = 100)
    private String slug;

    @Column(length = 150)
    private String seoTitle;

    @Column(length = 150)
    private String seoTitleDe;

    @Column(columnDefinition = "TEXT")
    private String seoDescription;

    @Column(columnDefinition = "TEXT")
    private String seoDescriptionDe;

    private String thumbImage;


    @Column(columnDefinition = "TEXT")
    private String shortDescription;

    @Column(columnDefinition = "TEXT")
    private String shortDescriptionDe;

    @Column(columnDefinition = "TEXT")
    private String longDescription;

    @Column(columnDefinition = "TEXT")
    private String longDescriptionDe;

    private double price;

    private Double offerPrice;

    private LocalDateTime offerStartDate;

    private LocalDateTime offerEndDate;

    private int quantity;

    @Column(unique = true)
    private String sku;

    private boolean showAtHome;

    private boolean showInAllCategories;

    private boolean showInProductCategory;

    private boolean showAtHomeCategory;

    @Column(name = "homepage_visibility")
    @Enumerated(EnumType.STRING)
    private ProductHomePageVisibility productHomePageVisibility;

    private boolean status;

    @Column(name = "is_top")
    private boolean isTop;

    @Column(name = "is_best")
    private boolean isBest;

    @Column(name = "is_feature")
    private boolean isFeature;

    private String video;

    @Column(unique = true)
    private String apiId;
}
