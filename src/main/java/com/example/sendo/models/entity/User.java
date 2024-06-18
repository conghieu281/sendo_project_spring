package com.example.sendo.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name= "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String phone;

    private String password;

    private Boolean status;

    @Column(name = "roleId", insertable = false, updatable = false)
    private Long roleId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "roleId", foreignKey = @ForeignKey(name = "fk_user_role"))
    private Role role;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Order> orderList;
}
