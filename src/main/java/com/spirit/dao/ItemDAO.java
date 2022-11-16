package com.spirit.dao;

import com.spirit.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemDAO extends JpaRepository<Item, Long> {

    Item save(Item item);

    List<Item> findAll();

    Optional<Item> findById(Long id);

    void delete(Item item);

}
