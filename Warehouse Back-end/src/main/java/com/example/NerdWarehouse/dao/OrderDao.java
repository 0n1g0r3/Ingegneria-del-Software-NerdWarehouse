package com.example.NerdWarehouse.dao;

import com.example.NerdWarehouse.entities.Order;
import com.example.NerdWarehouse.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDao extends JpaRepository<Order, Long> {
    @Override
    Optional<Order> findById(Long aLong);
    Optional<Order> findByUserEmail(String email);
    List<Order> getAllByUserId(Long id);

}
