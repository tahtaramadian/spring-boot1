package com.example.service.springboot.eccomerce.controller;

import com.example.service.springboot.eccomerce.model.Cart;
import com.example.service.springboot.eccomerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/")
    public List<Cart> getAll(){
        return cartService.findAll();
    }

    @PostMapping("/")
    public Cart add(@Valid @RequestBody Cart cart){
        return cartService.tambahCart(cart);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> update(@PathVariable(value = "id") Long id,
                                       @RequestBody Cart cart){
        return cartService.updateCart(id, cart);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") Long id){
        return cartService.deleteCart(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable(value = "id") Long id) {
        return cartService.findCartById(id);
    }

    @GetMapping("/item/{id}")
    public List<Cart> getAllCartByItemId(@PathVariable(value = "id") Long id) {
        return cartService.findAllCartByItemId(id);
    }

    @GetMapping("/buyers/{id}")
    public List<Cart> getAllCartByBuyersId(@PathVariable(value = "id") Long id) {
        return cartService.findAllCartByUserId(id);
    }
}
