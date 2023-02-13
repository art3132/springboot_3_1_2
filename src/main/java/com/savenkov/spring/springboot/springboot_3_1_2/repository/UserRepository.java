package com.savenkov.spring.springboot.springboot_3_1_2.repository;

import com.savenkov.spring.springboot.springboot_3_1_2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByCity(String city);
}
