package com.example.NerdWarehouse.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCT")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AVAILABLE")
    private Boolean available;

    @Column(name = "PRICE")
    private Float price;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IMAGE_NAME")
    private String imageName;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "PLATFORM")
    private String platform;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDERS_ID")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;





}