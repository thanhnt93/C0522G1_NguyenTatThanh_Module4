package com.codegym.model.employee;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "division")
    Set<Employee> employee;

    public Division() {
    }

    public Division(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
