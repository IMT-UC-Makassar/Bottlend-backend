package com.rvm.rvm.entity;

import java.security.Timestamp;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "history")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String item_name;
    private int quantity;
    private int total_point;
    private Timestamp transaction_date;

    @ManyToOne
    @JoinColumn(name = "history_user", nullable = false)
    private User user;
}
