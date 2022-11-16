package com.spirit.services;

import com.spirit.dao.OrderDAO;
import com.spirit.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDAO orderRepository;

    //create order
    public Order createOrder(Order order) {
        Order tempOrder = new Order( order.getCreationDateTime(), order.getItems());
        return orderRepository.save(tempOrder);
    }

    //get all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    //get order by id
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).get();
    }

    //update order
    public Order updateOrder (Long id, Order order) {
        Order tempOrder = orderRepository.findById(id).get();
        tempOrder.setCreationDateTime(order.getCreationDateTime());
        tempOrder.setItems(order.getItems());
        return orderRepository.save(tempOrder);
    }

    //delete order
    public void deleteOrder (Long id) {
        Order tempOrder = orderRepository.findById(id).get();
        orderRepository.delete(tempOrder);
    }

    //get all orders by date
    public List<Order> getAllByDate(String creationDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime start = LocalDate.parse(creationDateTime).atStartOfDay();
        LocalDateTime end = LocalDate.parse(creationDateTime).plusDays(1).atStartOfDay();
        return orderRepository.findByCreationDateTimeBetween(start, end);
    }
}
