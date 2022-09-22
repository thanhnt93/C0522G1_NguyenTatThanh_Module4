package com.codegym.model.employee;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


    @OneToMany(mappedBy = "position")
    private Set<Employee> employee;

    public Position() {
    }

    public Position(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
