package com.spirit.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "items")
public class Item {

    @ApiModelProperty(notes = "Item id", example = "1", required = true)
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(notes = "Item name", example = "apple")
    private String name;

    @ApiModelProperty(notes = "Item price", example = "100")
    private int price;

    @ManyToMany(mappedBy = "items")
    private List<Order> orders;

    protected Item () {}

    public Item (String name, int price){
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
