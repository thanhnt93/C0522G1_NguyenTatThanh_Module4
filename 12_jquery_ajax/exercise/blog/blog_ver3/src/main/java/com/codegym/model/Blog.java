package com.codegym.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String status;

    private String author;

    @Column(columnDefinition = "DATE")
    private String day;


    @ManyToOne
//    @JsonManagedReference
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(int id, String status, String author, String day, Category category) {
        this.id = id;
        this.status = status;
        this.author = author;
        this.day = day;
        this.category = category;
    }
}
