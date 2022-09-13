package com.codegym.service.impl;

import com.codegym.model.Mail;
import com.codegym.repository.IMailRepository;
import com.codegym.repository.impl.MailRepository;
import com.codegym.service.IMailService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MailService implements IMailService {
    IMailRepository mailRepository = new MailRepository();

    @Override
    public List<Mail> findAll() {
        return mailRepository.findAll();
    }

    @Override
    public void save(Mail mail) {
        mailRepository.save(mail);
    }

    @Override
    public void update(Mail mail) {
        mailRepository.update(mail);
    }

}
