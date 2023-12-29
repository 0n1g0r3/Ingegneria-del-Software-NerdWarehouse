package com.example.NerdWarehouse.services;


import com.example.NerdWarehouse.dao.OrderDao;
import com.example.NerdWarehouse.dao.ProductDao;
import com.example.NerdWarehouse.dao.UserDao;
import com.example.NerdWarehouse.dto.OrderDto;
import com.example.NerdWarehouse.dto.ProductDto;
import com.example.NerdWarehouse.entities.Order;
import com.example.NerdWarehouse.entities.Product;
import com.example.NerdWarehouse.entities.User;
import com.example.NerdWarehouse.services.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {


    private final OrderDao orderDao;
    private final ProductDao productDao;
    private final EmailObserver emailObserver;
    private final UserDao userDao;
    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public void save(Order order) {

        orderDao.save(order);
    }

    @Override
    public OrderDto saveDto(OrderDto orderDto) {
        Optional<User> user = userDao.findById(orderDto.getUserId());
        Order order  = modelMapper.map(orderDto, Order.class);
        order.setProductList(getProductList(orderDto));
        orderDao.save(order);
        for(ProductDto productDto : orderDto.getProductDtoList()){
            productDto.setAvailable(false);
            Product product = modelMapper.map(productDto, Product.class);
            product.setOrder(order);
            productDao.save(product);

        }
        emailObserver.sendEmail(order);
        return modelMapper.map(order, OrderDto.class);
    }

    private List<Product> getProductList(OrderDto orderDto) {
        return orderDto.getProductDtoList().stream()
                .map(productId -> productDao.findById(productId.getId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getAllByUser(Long uId) {
        Order order = orderDao.getById(uId);
        return orderDao.getAllByUserId(uId).stream().map(s -> modelMapper.map(s, OrderDto.class)).collect(Collectors.toList());

    }



}
