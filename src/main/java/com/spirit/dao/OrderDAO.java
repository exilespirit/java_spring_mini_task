package com.spirit.dao;

import com.spirit.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long> {

    Order save(Order order);

    List<Order> findAll();

    Optional<Order> findById(Long id);

    void delete (Order order);

    List<Order> findByCreationDateTimeBetween(LocalDateTime creationDateTimeStart, LocalDateTime creationDateTimeEnd);
}
