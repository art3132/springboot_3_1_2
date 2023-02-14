package com.savenkov.spring.springboot.springboot_3_1_2.dao;

import com.savenkov.spring.springboot.springboot_3_1_2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUser(long id);
    void deleteUser(long id);
}
