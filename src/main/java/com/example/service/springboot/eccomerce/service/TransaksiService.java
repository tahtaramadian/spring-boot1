package com.example.service.springboot.eccomerce.service;

import com.example.service.springboot.eccomerce.model.Transaksi;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TransaksiService {

    List<Transaksi> findAll();

    Transaksi addTransaksi(Transaksi transaksi);

    ResponseEntity<Transaksi> findTransaksiById(Long id);

    List<Transaksi> findAllTransaksiByUserId(Long id);

    List<Transaksi> findAllTransaksiByItemName(String namaItem);

}
