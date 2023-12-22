package com.example.NerdWarehouse.dao;

import com.example.NerdWarehouse.entities.Order;
import com.example.NerdWarehouse.entities.Product;
import com.example.NerdWarehouse.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface ProductDao extends JpaRepository<Product,Long> {

    @Override
    Optional<Product> findById(Long aLong);
    List<Product> findAllByTitle(String title);
    List<Product> findAllByUser(User user);
    List<Product> findAllByOrder(Order order);
    List<Product> findAllByAvailableIsTrue();

}