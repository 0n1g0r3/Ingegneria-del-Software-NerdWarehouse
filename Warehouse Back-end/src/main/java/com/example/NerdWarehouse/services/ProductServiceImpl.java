package com.example.NerdWarehouse.services;

import com.example.NerdWarehouse.dao.ProductDao;
import com.example.NerdWarehouse.dao.UserDao;
import com.example.NerdWarehouse.dto.ProductDto;
import com.example.NerdWarehouse.entities.Product;
import com.example.NerdWarehouse.entities.User;
import com.example.NerdWarehouse.services.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;
    private final UserDao userDao;
    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public ProductDto saveDto(ProductDto productDto) {

        Product product = modelMapper.map(productDto, Product.class);
        Optional<User> user = userDao.findById(productDto.getUserId());

                if (user.isPresent()) {
                    product.setUser(user.get());
                    product.setAvailable(true);
                    productDao.save(product);

                    return modelMapper.map(product, ProductDto.class);
                }

        return null;
    }



    public void deleteProductById(Long productId) {
        productDao.deleteById(productId);
    }




    @Override
    public List<ProductDto> getAll() {
        return productDao.findAll().stream()
                .map(product -> {
                    ProductDto productDto = modelMapper.map(product, ProductDto.class);
                    return productDto;
                }).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getAllByUserId(Long userId) {
        User user = userDao.getById(userId);

        return productDao.findAllByUser(user).stream()
                .map(product -> {
                    ProductDto productDto = modelMapper.map(product, ProductDto.class);
                    return productDto;
                })
                .collect(Collectors.toList());
    }


    @Override
    public List<ProductDto> getAllByTitleLike(String title) {
        return productDao.findAllByTitle(title).stream()
                .map(product -> {
                    ProductDto productDto = modelMapper.map(product, ProductDto.class);
                    return productDto;
                })
                .collect(Collectors.toList());
    }



    @Override
    public ProductDto getById(Long uId) {
        Optional<Product> productOptional = productDao.findById(uId);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            ProductDto productDto = modelMapper.map(product, ProductDto.class);
            return productDto;
        } else {
            // Gestire il caso in cui il prodotto con l'ID specificato non esista
            return null; // o sollevare un'eccezione o restituire un DTO vuoto, a seconda delle tue esigenze
        }
    }

}
