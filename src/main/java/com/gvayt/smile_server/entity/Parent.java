package com.gvayt.smile_server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="parents")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String fio;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "hash_password", nullable = false)
    private String hashPassword;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Kid> kids;
}
