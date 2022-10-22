package com.spirit.controllers;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class Controller {

    @PostMapping("/")
    public void createOrder() {

    }

    @GetMapping("/")
    public String getAllOrders() {
        return"Get All";
    }

    @GetMapping("/{id}")
    public void getOrderById(@PathVariable Long id) {}

    @PutMapping("/{id}")
    public void updateOrder(@PathVariable Long id) {}

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {}

    @GetMapping("/{date}")
    public void getOrdersByDate(@PathVariable LocalDateTime dateTime) {}

    @PostMapping("/item/")
    public void createItem() {}

    @GetMapping("/item")
    public void getAllItems() {}

    @GetMapping("/iem/{id}")
    public void getItemById(@PathVariable Long id) {}

    @PutMapping("/iem/{id}")
    public void updateItem(@PathVariable Long id) {}

    @DeleteMapping("/iem/{id}")
    public void deleteItem(@PathVariable Long id) {}
}
