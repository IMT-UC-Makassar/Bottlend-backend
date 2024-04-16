package com.rvm.rvm.entity;

import java.util.*;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String email;

    private String username;
    private String no_telp;
    private String address;
    private int point_total;
    private String uang;
    private int bottle_total;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<History> history;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_achievement",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "email"),
            inverseJoinColumns = @JoinColumn(name = "achievement_id", referencedColumnName = "achievement_name"))
    private Set<Achievement> achievements = new HashSet<>();
}
