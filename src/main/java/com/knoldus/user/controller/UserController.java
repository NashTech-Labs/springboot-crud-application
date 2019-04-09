package com.knoldus.user.controller;

import com.knoldus.user.models.User;
import com.knoldus.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {
    
    @Autowired
    private UserRepository repository;
    
    @RequestMapping("/")
    public String index() {
        return "Welcome to the CRUD application!!";
    }
    
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) {
        return repository.getUserById(id);
    }
    
    @PostMapping("/user/add")
    public User addUser(@RequestBody Map<String, String> body) {
        return repository.addUser(body.get("id"), body.get("name"), body.get("age"));
    }
}
