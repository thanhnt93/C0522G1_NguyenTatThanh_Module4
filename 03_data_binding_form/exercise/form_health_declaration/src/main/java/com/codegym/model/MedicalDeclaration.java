package com.codegym.model;

import lombok.Getter;
import lombok.Setter;

public class MedicalDeclaration {

    @Getter @Setter
    private String name;

    @Getter @Setter
    private Integer birthday;

    @Getter @Setter
    private String gender;

    @Getter @Setter
    private String country;

    @Getter @Setter
    private String identity;

    @Getter @Setter
    private String render;

    @Getter @Setter
    private String vehicleNumber;

    @Getter @Setter
    private String seats;

    @Getter @Setter
    private Integer starDay;

    @Getter @Setter
    private Integer starMonth;

    @Getter @Setter
    private Integer starYear;

    @Getter @Setter
    private Integer endDay;

    @Getter @Setter
    private Integer endMonth;

    @Getter @Setter
    private Integer endYear;

    @Getter @Setter
    private String information;

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(String name, Integer birthday, String gender,
                              String country, String identity, String render,
                              String vehicleNumber, String seats, Integer starDay,
                              Integer starMonth, Integer starYear, Integer endDay,
                              Integer endMonth, Integer endYear, String information) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.country = country;
        this.identity = identity;
        this.render = render;
        this.vehicleNumber = vehicleNumber;
        this.seats = seats;
        this.starDay = starDay;
        this.starMonth = starMonth;
        this.starYear = starYear;
        this.endDay = endDay;
        this.endMonth = endMonth;
        this.endYear = endYear;
        this.information = information;
    }
}
