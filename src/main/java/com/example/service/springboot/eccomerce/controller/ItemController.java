package com.example.service.springboot.eccomerce.controller;

import com.example.service.springboot.eccomerce.model.Item;
import com.example.service.springboot.eccomerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/")
    public List<Item> getAll() {
        return itemService.findAll();
    }

    @PostMapping("/")
    public Item addItem(@Valid @RequestBody Item items) {
        return itemService.tambahItem(items);
    }

    @PutMapping("/{idUser}")
    public ResponseEntity<Item> update(@PathVariable(value = "idItem") Long id, @RequestBody Item items) {
        return itemService.updateItem(id, items);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") Long id) {
        return itemService.deleteItem(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getById(@PathVariable(value = "id") Long id) {
        return itemService.getItemById(id);
    }
}
