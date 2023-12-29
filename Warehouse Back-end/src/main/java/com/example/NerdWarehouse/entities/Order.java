package com.example.NerdWarehouse.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TOTAL")
    private Float total;

    @Column(name = "PAYMENT_METHOD")
    private String paymentMethod;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List <Product> productList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;


}