package com.example.sendo.models.entity;

import jakarta.persistence.*;
import lombok.*;

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
}
