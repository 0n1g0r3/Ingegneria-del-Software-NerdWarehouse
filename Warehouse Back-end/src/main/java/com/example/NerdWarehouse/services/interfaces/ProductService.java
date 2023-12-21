package com.example.NerdWarehouse.services.interfaces;



import com.example.NerdWarehouse.dto.ProductDto;
import com.example.NerdWarehouse.entities.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);

    List<ProductDto> getAll();

    ProductDto saveDto(ProductDto productDto);

    ProductDto getById(Long uId);

    List<ProductDto> getAllByUserId(Long uId);

    void deleteProductById(Long uid);

    List<ProductDto> getAllByTitleLike(String title);


}
