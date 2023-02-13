package com.savenkov.spring.springboot.springboot_3_1_2.controller;

import com.savenkov.spring.springboot.springboot_3_1_2.entity.User;
import com.savenkov.spring.springboot.springboot_3_1_2.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> showAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @PostMapping("/users")
    public User addNewUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return "User with ID = " + id + " was deleted";
    }

    @GetMapping("/users/{city}")
    public List<User> findAllUsersByCity(@PathVariable String city) {
        return userService.findAllByCity(city);
    }
}
