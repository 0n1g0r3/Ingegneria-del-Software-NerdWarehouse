package com.example.NerdWarehouse.services;

import com.example.NerdWarehouse.entities.Order;
import com.example.NerdWarehouse.entities.Product;
import com.example.NerdWarehouse.services.interfaces.UserObserver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailObserver implements UserObserver {

    @Autowired
    private final EmailServiceImpl emailService;


    @Override
    public void sendEmail(Order order) {
        System.out.println(order.getProductList());
        emailService.sendSimpleEmail(order.getUser().getEmail(),"Creazione nuovo ordine","Ciao è stato creato un nuovo ordine!");
        for (Product product : order.getProductList()){
            emailService.sendSimpleEmail(product.getUser().getEmail(),"Creazione nuovo ordine","Ciao è stato acquistato un tuo prodotto!");
        }
    }
}
