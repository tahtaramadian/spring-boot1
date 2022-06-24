package com.example.service.springboot.eccomerce.service;

import com.example.service.springboot.eccomerce.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface UserService {

    List<User> findAll();

    User tambahUser(User user);

    ResponseEntity<User> updateUser(Long id, User detailUser);

    String deleteUser(Long id);

    ResponseEntity<User> getUserById(Long id);

}
