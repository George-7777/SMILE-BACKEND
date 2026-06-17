package com.gvayt.smile_server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "kids")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fio")
    private String fio;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(name = "hash_password", nullable = false)
    private String hashPassword;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", nullable = false)
    private Parent parent;
}
