package com.example.NerdWarehouse.services.interfaces;


import com.example.NerdWarehouse.dto.OrderDto;
import com.example.NerdWarehouse.entities.Order;

import java.util.List;

public interface OrderService {

    void save(Order order);

    OrderDto saveDto(OrderDto orderDto);

    List<OrderDto> getAllByUser(Long uId);
}
