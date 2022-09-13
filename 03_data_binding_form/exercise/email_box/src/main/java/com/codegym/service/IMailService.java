package com.codegym.service;

import com.codegym.model.Mail;

import java.util.List;

public interface IMailService {
    List<Mail> findAll();

    void save(Mail mail);

    void update(Mail mail);

}
