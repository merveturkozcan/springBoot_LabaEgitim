package com.merveturk.springBootLaba.ders6_ders7_JPA.service;

import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.BaseEntity;
import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.OrderJpa;
import com.merveturk.springBootLaba.ders6_ders7_JPA.entity.Users;
import jakarta.persistence.Entity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailService  {

    @Async
    public void sendMailUser(OrderJpa order , Users users) throws InterruptedException {
        String orderNumber = order.getOrderNumber();
        String name = users.getName();
        String email = users.getEmail();

        String mailBody = "Sevgili " + name + " siparisinizi aldik . Numarasi : " + orderNumber;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // send mail
    }

}
