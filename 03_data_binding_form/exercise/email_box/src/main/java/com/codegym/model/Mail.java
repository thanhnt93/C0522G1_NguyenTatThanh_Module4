package com.codegym.model;


import lombok.Getter;
import lombok.Setter;

public class Mail {

    @Getter @Setter
    private int id;

    @Getter @Setter
    private String languages;

    @Getter @Setter
    private String pageSize;

    @Getter @Setter
    private String spamsFilter;

    @Getter @Setter
    private String signature;

    public Mail() {
    }

    public Mail(int id, String languages, String pageSize, String spamsFilter, String signature) {
        this.id = id;
        this.languages = languages;
        this.pageSize = pageSize;
        this.spamsFilter = spamsFilter;
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "languages='" + languages + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", spamsFilter='" + spamsFilter + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
