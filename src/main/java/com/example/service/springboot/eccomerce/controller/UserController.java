package com.example.service.springboot.eccomerce.controller;

import com.example.service.springboot.eccomerce.model.User;
import com.example.service.springboot.eccomerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<User> getAll(){
        return userService.findAll();
    }

    @PostMapping("/")
    public User addUser(@Valid @RequestBody User users){
        return userService.tambahUser(users);
    }

    @PutMapping("/{idUser}")
    public ResponseEntity<User> update(@PathVariable(value = "idUser") Long id, @RequestBody User users){
        return userService.updateUser(id, users);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") Long id){
        return userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable(value = "id") Long id){
        return userService.getUserById(id);
    }
}
