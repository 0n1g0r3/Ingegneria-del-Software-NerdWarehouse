package com.example.NerdWarehouse.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class OrderDto {
    private Float totalPrice;
    private String paymentMethod;
    private Long userId;
    private List<ProductDto> productDtoList;
}
