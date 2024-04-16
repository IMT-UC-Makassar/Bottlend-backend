package com.rvm.rvm.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "achievement")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Achievement {
    @Id
    private String achievement_name;

    private String mission;
    private int point;
    private boolean status;

    @ManyToOne
    private User user;
}
