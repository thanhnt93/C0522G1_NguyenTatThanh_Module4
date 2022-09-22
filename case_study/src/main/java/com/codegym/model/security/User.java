package com.codegym.model.security;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    private String userName;
    private String userPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_name"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))

    private List<Role> roles;

    public User() {
    }

    public User(String userName, String userPassword, List<Role> roles) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.roles = roles;
    }
}
