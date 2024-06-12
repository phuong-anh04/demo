package com.happydecor.usermanagement.controller;

import com.happydecor.usermanagement.model.User;
import com.happydecor.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String adminDashboard(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }

    @PostMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

    @PostMapping("/admin/promote/{id}")
    public String promoteUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            user.setRole("ADMIN");
            userService.saveUser(user);
        }
        return "redirect:/admin";
    }
}
