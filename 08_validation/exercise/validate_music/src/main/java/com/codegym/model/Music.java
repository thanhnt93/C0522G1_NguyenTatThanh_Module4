package com.codegym.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameMusic;
    private String author;
    private String typeOfMusic;
    private String link;

    public Music() {
    }

    public Music(int id, String nameMusic, String author, String typeOfMusic, String link) {
        this.id = id;
        this.nameMusic = nameMusic;
        this.author = author;
        this.typeOfMusic = typeOfMusic;
        this.link = link;
    }
}

