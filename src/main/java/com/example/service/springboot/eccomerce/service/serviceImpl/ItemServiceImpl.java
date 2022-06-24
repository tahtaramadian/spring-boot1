package com.example.service.springboot.eccomerce.service.serviceImpl;


import com.example.service.springboot.eccomerce.model.Item;
import com.example.service.springboot.eccomerce.repository.ItemRepository;
import com.example.service.springboot.eccomerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item tambahItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public ResponseEntity<Item> updateItem(Long id, Item detailItem) {

        Optional<Item> item = itemRepository.findById(id);
        if (!item.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Item item1 = item.get();
        if (item1.getNamaItem() != null) {
            item1.setNamaItem(item1.getNamaItem());
        }

        if (item1.getHargaItem() != 0) {
            item1.setHargaItem(item1.getHargaItem());
        }

        if (item1.getJmlItem() != 0){
            item1.setJmlItem(item1.getJmlItem());
        }

        Item updatedItem = itemRepository.save(item1);
        return ResponseEntity.ok(updatedItem);
    }

    @Override
    public String deleteItem(Long id) {

        Optional<Item> item = itemRepository.findById(id);
        String result = "";
        if (!item.isPresent()) {
            result = "id" + id + "tidak ditemukan";
            return result;
        }
        result = "id" + id + "berhasil dihapus";
        itemRepository.deleteById(id);
        return result;
    }

    @Override
    public ResponseEntity<Item> getItemById(Long id) {
        Optional<Item> items = itemRepository.findById(id);
        if (!items.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Item item1 = items.get();
        return ResponseEntity.ok().body(item1);
    }

}
