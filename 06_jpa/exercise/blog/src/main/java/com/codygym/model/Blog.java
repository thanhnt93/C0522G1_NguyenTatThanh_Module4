package com.codygym.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String status;

    @Getter
    @Setter
    private String type;


    @Column(columnDefinition = "DATE")
    @Getter
    @Setter
    private String day;

    @Getter
    @Setter
    private String title;


    public Blog() {
    }

    public Blog(int id, String status, String type, String day, String title) {
        this.id = id;
        this.status = status;
        this.type = type;
        this.day = day;
        this.title = title;
    }


    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", day=" + day +
                '}';
    }
}
