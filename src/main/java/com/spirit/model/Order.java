package com.spirit.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime creationDateTime;
    @ManyToMany
    @JoinTable(
            name="order_item",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    List<Item> items;

    protected Order () {}

    public Order(LocalDateTime creationDateTime, List<Item> items) {
        this.creationDateTime = creationDateTime;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
