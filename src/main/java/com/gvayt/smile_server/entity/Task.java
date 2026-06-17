package com.gvayt.smile_server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Data
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "text")
    private String text;

    @Column(name = "time")
    private LocalTime localTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kid_id", nullable = false)
    private Kid kid;
}
