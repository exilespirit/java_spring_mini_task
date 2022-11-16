package com.spirit.controllers;

import com.spirit.model.Item;
import com.spirit.model.Order;
import com.spirit.services.ItemService;
import com.spirit.services.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "Create a new order", notes = "Returns created order")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created")
    })
    @PostMapping("/")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @ApiOperation(value = "Get list of all orders", notes = "Returns list of all orders")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Orders list provided"),
            @ApiResponse(code = 404, message = "No orders found")
    })
    @GetMapping("/")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @ApiOperation(value = "Get order by id", notes = "Returns order with requested id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Order provided"),
            @ApiResponse(code = 404, message = "Order not found")
    })
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable @ApiParam(name = "id", value = "Order id", example = "1") Long id) {
        return orderService.getOrderById(id);
    }

    @ApiOperation(value = "Update order", notes = "Finds order by id and returns it with updated fields")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Order updated"),
            @ApiResponse(code = 404, message = "Order not found")
    })
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable  @ApiParam(name = "id", value = "Order id", example = "1") Long id,
                             @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    @ApiOperation(value = "Delete order", notes = "Deletes order with provided id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Order deleted"),
            @ApiResponse(code = 404, message = "Order not found")
    })
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable @ApiParam(name = "id", value = "Order id", example = "1") Long id) {
        orderService.deleteOrder(id);
    }

    @ApiOperation(value = "Get list of all orders with provided creation date", notes = "Returns list of orders")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Orders list provided"),
            @ApiResponse(code = 404, message = "No orders found")
    })
    @GetMapping("/by_date")
    public List<Order> getOrdersByDate(
            @RequestParam @ApiParam(name = "dateTime", value = "Order date", example = "2022-11-07")
            String date) {
        return orderService.getAllByDate(date);
    }

    @ApiOperation(value = "Create a new item", notes = "Returns created item")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created")
    })
    @PostMapping("/item/")
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @ApiOperation(value = "Get list of all items", notes = "Returns list of all items")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Items list provided"),
            @ApiResponse(code = 404, message = "No items found")
    })
    @GetMapping("/item")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @ApiOperation(value = "Get item by id", notes = "Returns item with requested id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Item provided"),
            @ApiResponse(code = 404, message = "Item not found")
    })
    @GetMapping("/item/{id}")
    public Item getItemById(@PathVariable @ApiParam(name = "id", value = "Item id", example = "1") Long id) {
        return itemService.getItemById(id);
    }

    @ApiOperation(value = "Update item", notes = "Finds item by id and returns it with updated fields")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Item updated"),
            @ApiResponse(code = 404, message = "Item not found")
    })
    @PutMapping("/item/{id}")
    public Item updateItem(@PathVariable @ApiParam(name = "id", value = "Item id", example = "1") Long id,
                           @RequestBody Item item) {
        return itemService.updateItem(id, item);
    }

    @ApiOperation(value = "Delete item", notes = "Deletes item with provided id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Item deleted"),
            @ApiResponse(code = 404, message = "Item not found")
    })
    @DeleteMapping("/item/{id}")
    public void deleteItem(@PathVariable @ApiParam(name = "id", value = "Item id", example = "1") Long id) {
        itemService.deleteItem(id);
    }
}
