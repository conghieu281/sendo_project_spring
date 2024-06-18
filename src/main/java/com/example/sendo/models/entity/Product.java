package com.example.sendo.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String color;

    private String size;

    private Integer stock;

    private Double price;

    private String description;

    @Column(name = "categoryId", updatable = false, insertable = false)
    private Long categoryId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "categoryId", foreignKey = @ForeignKey(name = "fk_product_category"))
    private Category category;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OderDetail> oderDetailList;

    public Product(Long id) {
        this.id = id;
    }
}
