package com.example.NerdWarehouse.services.interfaces;

import com.example.NerdWarehouse.entities.Order;

public interface UserObserver {
    void sendEmail(Order order);
}
