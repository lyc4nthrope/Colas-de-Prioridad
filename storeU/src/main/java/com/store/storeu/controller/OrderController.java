package com.store.storeu.controller;

import com.store.storeu.model.Order;
import com.store.storeu.service.PriorityQueueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
public class OrderController {
    private final PriorityQueueService service;
    public OrderController(PriorityQueueService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order data) {
        Order o = service.addOrder(data.getName(), data.getRole());
        return ResponseEntity.ok(o);
    }

    @GetMapping
    public Order[] list() {
        return service.listOrders();
    }

    @DeleteMapping("/attend")
    public ResponseEntity<Order> attend() {
        Order o = service.attendOrder();
        if (o == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(o);
    }
}