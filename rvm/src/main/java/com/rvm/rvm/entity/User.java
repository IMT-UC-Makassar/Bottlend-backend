package com.rvm.rvm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "user")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails{
    @Id
    private String email;

    private String username;
    private String no_telp;
    private String address;
    private int point_total;
    private String uang;
    private int bottle_total;
    
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<History> history;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_achievement",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "email"),
            inverseJoinColumns = @JoinColumn(name = "achievement_id", referencedColumnName = "achievement_name"))
    private Set<Achievement> achievements = new HashSet<>();

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
}
