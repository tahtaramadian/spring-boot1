package com.example.service.springboot.eccomerce.controller;

import com.example.service.springboot.eccomerce.model.Transaksi;
import com.example.service.springboot.eccomerce.repository.TransaksiRepository;
import com.example.service.springboot.eccomerce.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transaksi")
public class TransaksiController {

    @Autowired
    TransaksiService transaksiService;

    @GetMapping("/")
    public List<Transaksi> getAll() {
        return transaksiService.findAll();
    }

    @PostMapping("/")
    public Transaksi add(@Valid @RequestBody Transaksi transaksi) {
        return transaksiService.addTransaksi(transaksi);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaksi> getTransactionById(@PathVariable(value = "id") Long id) {
        return transaksiService.findTransaksiById(id);
    }

    @GetMapping("/user/{id}")
    public List<Transaksi> getAllTransactionByUsersId(@PathVariable(value = "id") Long id) {
        return transaksiService.findAllTransaksiByUserId(id);
    }

    @GetMapping("/item/{itemName}")
    public List<Transaksi> getAllTransactionByItemName(@PathVariable(value = "itemName") String itemName) {
        return transaksiService.findAllTransaksiByItemName(itemName);
    }

}
