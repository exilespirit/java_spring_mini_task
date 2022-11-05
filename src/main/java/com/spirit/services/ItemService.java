package com.spirit.services;

import com.spirit.dao.ItemDAO;
import com.spirit.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemDAO itemRepository;

    //create item
    public Item createItem(Item item) {
        Item tempItem = new Item(item.getName(), item.getPrice());
        return itemRepository.save(tempItem);
    }

    //get all items
    public List<Item> getAllItems() {
        return (List<Item>) itemRepository.findAll();
    }

    //get item by id
    public Item getItemById(Long id) {
        return itemRepository.findById(id).get();
    }

    //update item
    public Item updateItem(Long id, Item item) {
        Item tempItem = itemRepository.findById(id).get();
        tempItem.setName(item.getName());
        tempItem.setPrice(item.getPrice());
        return itemRepository.save(tempItem);
    }

    //delete item
    public void deleteItem(Long id) {
        Item item = itemRepository.findById(id).get();
        itemRepository.delete(item);
    }
}
