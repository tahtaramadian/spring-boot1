package com.example.service.springboot.eccomerce.repository;

import com.example.service.springboot.eccomerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
