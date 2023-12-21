package com.example.NerdWarehouse.controller;


import com.example.NerdWarehouse.dto.ProductDto;
import com.example.NerdWarehouse.services.interfaces.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Product") //Name displayed on swagger
public class ProductController {

    private final ProductService productService;

    @Autowired(required = false)
    private HttpServletRequest request;

    @GetMapping("/products/{userId}")
    public ResponseEntity<List<ProductDto>> getAllByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(productService.getAllByUserId(userId));
    }

    @GetMapping("/all-products")
    public ResponseEntity<List<ProductDto>> getAll() {

        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @GetMapping("/product/title")
    public ResponseEntity <List<ProductDto>> findByTitleLike(String title) {
        return ResponseEntity.ok(productService.getAllByTitleLike(title));
    }


    @PostMapping("/products")
    public ResponseEntity<ProductDto> addProduct(@RequestBody @Valid ProductDto productDto) {
        return ResponseEntity.ok(productService.saveDto(productDto));
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.deleteProductById(productId);
        return ResponseEntity.noContent().build();
    }



}