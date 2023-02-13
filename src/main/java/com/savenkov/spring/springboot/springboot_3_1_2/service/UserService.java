package com.savenkov.spring.springboot.springboot_3_1_2.service;

import com.savenkov.spring.springboot.springboot_3_1_2.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUser(long id);
    void deleteUser(long id);
    List<User> findAllByCity(String city);
}
