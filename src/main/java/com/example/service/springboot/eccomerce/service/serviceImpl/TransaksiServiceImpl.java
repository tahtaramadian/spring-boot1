package com.example.service.springboot.eccomerce.service.serviceImpl;

import com.example.service.springboot.eccomerce.model.Cart;
import com.example.service.springboot.eccomerce.model.Item;
import com.example.service.springboot.eccomerce.model.Transaksi;
import com.example.service.springboot.eccomerce.repository.CartRepository;
import com.example.service.springboot.eccomerce.repository.ItemRepository;
import com.example.service.springboot.eccomerce.repository.TransaksiRepository;
import com.example.service.springboot.eccomerce.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransaksiServiceImpl implements TransaksiService {

    @Autowired
    TransaksiRepository transaksiRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CartRepository cartRepository;

    @Override
    public List<Transaksi> findAll() {
        return transaksiRepository.findAll();
    }

    @Override
    public Transaksi addTransaksi(Transaksi transaksi) {
        List<Cart> carts = cartRepository.findByIdIn(transaksi.getIdsCart());
        carts = carts.stream()
                .filter(a -> Objects.equals(a.getIdUser(), transaksi.getIdUser()))
                .collect(Collectors.toList());
        if (!carts.isEmpty()) {
            double totalPrice = 0d;
            List<String> namaItems = new ArrayList<>();
            List<String> cartId = new ArrayList<>();
            for (Cart cart1 : carts) {
                Optional<Item> item = itemRepository.findById(cart1.getIdItem());
                if (item.isPresent()) {
                    Item item1 = item.get();
                    int sisaItem = item1.getJmlItem() - cart1.getJmlItem();
                    item1.setJmlItem(sisaItem);
                    itemRepository.save(item1);
                    totalPrice += cart1.getTotalHarga();
                    namaItems.add(item1.getNamaItem());
                    cartId.add(String.valueOf(cart1.getId()));
                }
                cartRepository.deleteById(cart1.getId());
            }
            transaksi.setNamaItem(String.join(",", namaItems));
            transaksi.setIdCart(String.join(",", cartId));
            transaksi.setJmlTransaksi(totalPrice);
        }
        return transaksiRepository.save(transaksi);
    }

    @Override
    public ResponseEntity<Transaksi> findTransaksiById(Long id) {
        Optional<Transaksi> transaksi = transaksiRepository.findById(id);
        String result = "";
        if (!transaksi.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Transaksi transaksi1 = transaksi.get();
        return ResponseEntity.ok().body(transaksi1);
    }

    @Override
    public List<Transaksi> findAllTransaksiByUserId(Long id) {
        return transaksiRepository.findByIdUser(id);
    }

    @Override
    public List<Transaksi> findAllTransaksiByItemName(String namaItem) {
        return transaksiRepository.findBynamaItem(namaItem);
    }
}
