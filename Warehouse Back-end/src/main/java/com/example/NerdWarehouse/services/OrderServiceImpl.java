package com.example.NerdWarehouse.services;


import com.example.NerdWarehouse.dao.OrderDao;
import com.example.NerdWarehouse.dto.OrderDto;
import com.example.NerdWarehouse.entities.Order;
import com.example.NerdWarehouse.services.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {


    private final OrderDao orderDao;
    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public void save(Order order) {

        orderDao.save(order);
    }

    @Override
    public OrderDto saveDto(OrderDto orderDto) {
        Order order  = modelMapper.map(orderDto, Order.class);
        orderDao.save(order);
        return modelMapper.map(order, OrderDto.class);
    }

    @Override
    public List<OrderDto> getAllByUser(Long uId) {
        Order order = orderDao.getById(uId);
        return orderDao.getAllByUserId(uId).stream().map(s -> modelMapper.map(s, OrderDto.class)).collect(Collectors.toList());

    }



}
