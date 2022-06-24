package com.example.service.springboot.eccomerce.service;

import com.example.service.springboot.eccomerce.model.Item;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ItemService {
    List<Item> findAll();

    Item tambahItem(Item item);

    ResponseEntity<Item> updateItem(Long id, Item detailItem);

    String deleteItem(Long id);

    ResponseEntity<Item> getItemById(Long id);
}