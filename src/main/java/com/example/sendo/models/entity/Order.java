package com.example.sendo.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bill")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDate;

    private Double totalPrice;

    private String address;

    @Column(name = "customerId", insertable = false, updatable = false)
    private Long customerId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "customerId", foreignKey = @ForeignKey(name = "fk_order_customer"))
    private User customer;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OderDetail> oderDetailList;

    public Order(Long id) {
        this.id = id;
    }
}
