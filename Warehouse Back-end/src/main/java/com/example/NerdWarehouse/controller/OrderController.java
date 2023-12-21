package com.example.NerdWarehouse.controller;


import com.example.NerdWarehouse.dto.OrderDto;
import com.example.NerdWarehouse.services.interfaces.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Tag(name = "Order") //Name displayed on swagger
public class OrderController {

    private final OrderService orderService;
    @GetMapping("/orders/{userId}")
    public ResponseEntity<List<OrderDto>> getAllByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.getAllByUser(userId));
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderDto> addOrder(@RequestBody @Valid OrderDto orderDto) {
        return ResponseEntity.ok(orderService.saveDto(orderDto));
    }

}
