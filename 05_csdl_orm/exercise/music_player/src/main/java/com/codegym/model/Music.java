package com.codegym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTypeOfMusic() {
        return typeOfMusic;
    }

    public void setTypeOfMusic(String typeOfMusic) {
        this.typeOfMusic = typeOfMusic;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Music{" +
                "nameMusic='" + nameMusic + '\'' +
                ", author='" + author + '\'' +
                ", typeOfMusic='" + typeOfMusic + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
