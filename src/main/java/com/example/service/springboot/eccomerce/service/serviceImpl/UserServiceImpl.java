package com.example.service.springboot.eccomerce.service.serviceImpl;

import com.example.service.springboot.eccomerce.model.User;
import com.example.service.springboot.eccomerce.repository.UserRepository;
import com.example.service.springboot.eccomerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User tambahUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<User> updateUser(Long id, User detailUser) {

        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()){
            return ResponseEntity.notFound().build();
        }

        User user1 = user.get();
        if (user1.getNamaDepan() != null){
            user1.setNamaDepan(user1.getNamaDepan());
        }

        if (user1.getNamaBelakang() != null){
            user1.setNamaBelakang(user1.getNamaBelakang());
        }

        if (user1.getAlamat() != null){
            user1.setAlamat(user1.getAlamat());
        }

        if (user1.getEmail() != null){
            user1.setEmail(user1.getEmail());
        }

        if (user1.getNoTelpon() != null){
            user1.setNoTelpon(user1.getNoTelpon());
        }

        User updatedUser = userRepository.save(user1);
        return ResponseEntity.ok(updatedUser);
    }

    @Override
    public String deleteUser(Long id) {

        Optional<User> user = userRepository.findById(id);
        String result = "";
        if (!user.isPresent()){
            result = "id" + id + "tidak ditemukan";
            return result;
        }
        result = "id" + id + "berhasil dihapus";
        userRepository.deleteById(id);
        return result;
    }

    @Override
    public ResponseEntity<User> getUserById(Long id) {
        Optional<User> users = userRepository.findById(id);
        if (!users.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        User user1 = users.get();
        return ResponseEntity.ok().body(user1);
    }


}
