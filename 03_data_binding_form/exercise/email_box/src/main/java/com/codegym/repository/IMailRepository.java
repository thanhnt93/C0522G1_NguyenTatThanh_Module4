package com.codegym.repository;

import com.codegym.model.Mail;

import java.util.List;

public interface IMailRepository {
    List<Mail> findAll();

    void save(Mail mail);

    void update(Mail mail);

}
