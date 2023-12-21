package com.example.NerdWarehouse.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto {
    private String title;
    private Float price;
    private String description;
    private Boolean available;
    private Long userId;
}
