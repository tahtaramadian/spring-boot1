package com.example.service.springboot.eccomerce.repository;

import com.example.service.springboot.eccomerce.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransaksiRepository extends JpaRepository<Transaksi, Long>{
    List<Transaksi> findByIdUser(Long idUser);
    List<Transaksi> findBynamaItem(String namaItem);
}
