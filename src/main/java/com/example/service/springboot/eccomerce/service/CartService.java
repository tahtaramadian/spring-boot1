package com.example.service.springboot.eccomerce.service;

import com.example.service.springboot.eccomerce.model.Cart;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CartService {

    List<Cart> findAll();

    Cart tambahCart(Cart cart);

    ResponseEntity<Cart> updateCart(Long id, Cart cart);

    String deleteCart(Long id);

    ResponseEntity<Cart> findCartById(Long id);

    List<Cart> findAllCartByItemId(Long id);

    List<Cart> findAllCartByUserId(Long id);

}
