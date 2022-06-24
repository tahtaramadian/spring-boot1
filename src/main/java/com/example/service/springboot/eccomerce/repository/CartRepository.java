package com.example.service.springboot.eccomerce.repository;

import com.example.service.springboot.eccomerce.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByIdUser(Long idUser);
    List<Cart> findByIdItem(Long idItem);
    List<Cart> findByIdIn(List<Long> cartIds);
}
