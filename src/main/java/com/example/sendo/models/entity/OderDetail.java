package com.example.sendo.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

@Entity
@Table
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "productId", insertable = false, updatable = false)
    private Long productId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "productId", foreignKey = @ForeignKey(name = "fk_detail_product"))
    private Product product;

    @Column(name = "orderId", insertable = false, updatable = false)
    private Long orderId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "orderId", foreignKey = @ForeignKey(name = "fk_detail_order"))
    private Order order;

    private Integer quantity;

}
