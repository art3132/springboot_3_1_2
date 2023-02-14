package com.savenkov.spring.springboot.springboot_3_1_2.controller;

import com.savenkov.spring.springboot.springboot_3_1_2.entity.User;
import com.savenkov.spring.springboot.springboot_3_1_2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "all-users";
    }

    @GetMapping("/user-create")
    public String getUserForm(User user) {
        return "create-user";
    }

    @PostMapping("/user-create")
    public String addNewUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUserForm(@PathVariable long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}
