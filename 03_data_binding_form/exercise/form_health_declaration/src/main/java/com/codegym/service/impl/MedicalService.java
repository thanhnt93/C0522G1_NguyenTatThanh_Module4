package com.codegym.service.impl;

import com.codegym.model.MedicalDeclaration;
import com.codegym.repository.IMedicalRepository;
import com.codegym.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalService implements IMedicalService {
    @Autowired
    IMedicalRepository medicalRepository;

    @Override
    public List<Integer> birthdayList() {
        return medicalRepository.birthdayList();
    }

    @Override
    public List<String> genderList() {
        return medicalRepository.genderList();
    }

    @Override
    public List<String> countryList() {
        return medicalRepository.countryList();
    }

    @Override
    public List<String> renderList() {
        return medicalRepository.renderList();
    }

    @Override
    public List<Integer> starDayList() {
        return medicalRepository.starDayList();
    }

    @Override
    public List<Integer> starMonthList() {
        return medicalRepository.starMonthList();
    }

    @Override
    public List<Integer> starYearList() {
        return medicalRepository.starYearList();
    }

    @Override
    public List<Integer> endDayList() {
        return medicalRepository.endDayList();
    }

    @Override
    public List<Integer> endMonthList() {
        return medicalRepository.endMonthList();
    }

    @Override
    public List<Integer> endYearList() {
        return medicalRepository.endYearList();
    }

    @Override
    public List<MedicalDeclaration> findAll() {
        return medicalRepository.findAll();
    }

    @Override
    public MedicalDeclaration findOne(String identity) {
        return medicalRepository.findOne(identity);
    }

    @Override
    public void update(String identity, MedicalDeclaration medicalDeclaration) {
        medicalRepository.update(identity, medicalDeclaration);
    }

    @Override
    public void save(MedicalDeclaration medicalDeclaration) {
        medicalRepository.save(medicalDeclaration);
    }
}
