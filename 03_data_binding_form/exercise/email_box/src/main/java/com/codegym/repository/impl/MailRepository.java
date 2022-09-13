package com.codegym.repository.impl;

import com.codegym.model.Mail;
import com.codegym.repository.IMailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Repository
public class MailRepository implements IMailRepository {
    private static List<Mail> emailList;

    static {
        emailList = new ArrayList<>();
        emailList.add(new Mail(1,"English", "5", "no", "no"));
        emailList.add(new Mail(2,"Vietnamese", "15", "yes", "no"));
        emailList.add(new Mail(3,"Chinese", "25", "yes", "no"));
        emailList.add(new Mail(4,"Japanese", "5", "no", "no"));
    }

    @Override
    public List<Mail> findAll() {
        return emailList;
    }

    @Override
    public void save(Mail mail) {
        emailList.add(mail);
    }

    @Override
    public void update(Mail mail) {
        for (Mail item : emailList) {
            if (mail.getId() == item.getId()) {
                emailList.remove(item);
                emailList.add(mail);
                return;
            }
        }
    }


}
