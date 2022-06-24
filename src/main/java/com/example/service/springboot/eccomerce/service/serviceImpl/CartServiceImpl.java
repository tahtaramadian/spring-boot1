package com.example.service.springboot.eccomerce.service.serviceImpl;

import com.example.service.springboot.eccomerce.model.Cart;
import com.example.service.springboot.eccomerce.model.Item;
import com.example.service.springboot.eccomerce.repository.CartRepository;
import com.example.service.springboot.eccomerce.repository.ItemRepository;
import com.example.service.springboot.eccomerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart tambahCart(Cart cart) {
        Optional<Item> item = itemRepository.findById(cart.getIdItem());
        if (item.isPresent()) {
            Item item1 = item.get();
            double totalPrice = cart.getJmlItem() * item1.getHargaItem();
            cart.setTotalHarga(totalPrice);
            itemRepository.save(item1);
        }
        return cartRepository.save(cart);
    }

    @Override
    public ResponseEntity<Cart> updateCart(Long id, Cart cart) {
        Optional<Cart> cart1 = cartRepository.findById(id);
        if (!cart1.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Cart cart2 = cart1.get();

        if (cart2.getIdUser() != null){
            cart2.setIdUser(cart2.getIdUser());
        }

        if (cart2.getIdItem() != null) {
            cart2.setIdItem(cart2.getIdItem());
        }

        if (cart2.getJmlItem() != 0) {
            cart2.setJmlItem(cart2.getJmlItem());
        }

        Cart updateCart = cartRepository.save(cart2);
        return ResponseEntity.ok(updateCart);
    }


    @Override
    public String deleteCart(Long id) {
        Optional<Cart> cart = cartRepository.findById(id);
        String result = "";
        if (!cart.isPresent()) {
            result = "id " + id + " tidak ditemukan";
            return result;
        }
        result = "id " + id + " berhasil di hapus";
        cartRepository.deleteById(id);
        return result;
    }

    @Override
    public ResponseEntity<Cart> findCartById(Long id) {
        Optional<Cart> cart = cartRepository.findById(id);
        if (!cart.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Cart cart1 = cart.get();
        return ResponseEntity.ok().body(cart1);
    }

    @Override
    public List<Cart> findAllCartByItemId(Long id) {
        return cartRepository.findByIdItem(id);
    }

    @Override
    public List<Cart> findAllCartByUserId(Long id) {
        return cartRepository.findByIdUser(id);
    }
}
