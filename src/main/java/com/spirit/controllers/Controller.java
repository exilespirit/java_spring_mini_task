package com.spirit.controllers;

import com.spirit.model.Item;
import com.spirit.model.Order;
import com.spirit.services.ItemService;
import com.spirit.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    @GetMapping("/by_date")
    public List<Order> getOrdersByDate(@RequestParam String dateTime) {
        return orderService.getAllByDate(dateTime);
    }

    @PostMapping("/item/")
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @GetMapping("/item")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/item/{id}")
    public Item getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @PutMapping("/item/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
        return itemService.updateItem(id, item);
    }

    @DeleteMapping("/item/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }
}
