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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> productList;

    public Category(Long id) {
        this.id = id;
    }
}
