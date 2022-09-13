package com.codegym.service;

import com.codegym.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalService {
    List<Integer> birthdayList();
    List<String> genderList();
    List<String> countryList();
    List<String> renderList();
    List<Integer> starDayList();
    List<Integer> starMonthList();
    List<Integer> starYearList();
    List<Integer> endDayList();
    List<Integer> endMonthList();
    List<Integer> endYearList();
    List<MedicalDeclaration> findAll();

    MedicalDeclaration findOne(String identity);

    void update(String identity, MedicalDeclaration medicalDeclaration);

    void save(MedicalDeclaration medicalDeclaration);
}
