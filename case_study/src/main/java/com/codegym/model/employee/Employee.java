package com.codegym.model.employee;

import com.codegym.model.contract.Contract;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String birthday;
    private String idCard;
    private double salary;
    private String numberPhone;
    private String email;
    private String address;

    private Integer isDelete=0;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "educationDegree_id", referencedColumnName = "id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "id")
    private Division division;

    @OneToMany(mappedBy = "employee")
    Set<Contract> contract;

    public Employee() {
    }

    public Employee(int id, String name, String birthday, String idCard, double salary, String numberPhone, String email, String address, Integer isDelete, Position position, EducationDegree educationDegree, Division division) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
        this.isDelete = isDelete;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
    }
}
