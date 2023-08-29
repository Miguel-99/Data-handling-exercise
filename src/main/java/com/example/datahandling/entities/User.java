package com.example.datahandling.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Builder @Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String username;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Question> questions;

    private LocalDate createdAt;

    private String name;
    private String lastName;
    private String phoneNumber;
    private String country;
    private String gender;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}

//@Entity
//@Table(name = "users")
//public class User {
//
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id @Column(name = "id_user")
//    Long id;
//
////    @OneToMany(mappedBy = "user")
//    private Set<UserRole> userRoles = new HashSet<>();
//
//    @JsonManagedReference
////    @OneToOne(mappedBy = "user")
//    private InternalUser internalUser;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public InternalUser getInternalUser() {
//        return internalUser;
//    }
//
//    public void setInternalUser(InternalUser internalUser) {
//        this.internalUser = internalUser;
//    }
//
//    public Set<UserRole> getUserRoles() {
//        return userRoles;
//    }
//
//    public void setUserRoles(Set<UserRole> userRoles) {
//        this.userRoles = userRoles;
//    }
//}
