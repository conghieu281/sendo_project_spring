package com.example.sendo.models.entity;

import com.example.sendo.models.Enum.ERoles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "role")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    @Enumerated(EnumType.STRING)
    private ERoles roleName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "role" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<User> userList;

    public Role(Long id) {
        this.id = id;
    }
}
