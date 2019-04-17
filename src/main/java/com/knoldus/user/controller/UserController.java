package com.knoldus.user.controller;

import com.knoldus.user.models.User;
import com.knoldus.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    
    @Autowired
    private UserRepository repository;
    
    @RequestMapping("/")
    public String index() {
        return "Welcome to the CRUD application!!";
    }
    
    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable String id) {
        return repository.findById(id);
    }
    
    @PostMapping("/user/add")
    public User addUser(@RequestBody User newUser) {
        User bob = User.builder()
                .id(newUser.getId())
                .name(newUser.getName())
                .age(newUser.getAge())
                .build();
        return repository.save(bob);
    }
    
    @PutMapping("/user/update/{id}/{name}/{age}")
    public Optional<User> updateUser(@PathVariable String id, @PathVariable String name, @PathVariable String age) {
        Optional<User> existingUser = repository.findById(id);
        if (existingUser.isPresent()) {
            User newUser = repository.save(User.builder()
                    .id(id)
                    .name(name)
                    .age(age)
                    .build());
            return Optional.of(newUser);
        }
        return existingUser;
    }
    
    @DeleteMapping("/user/delete/{idToBeDeleted}")
    public String deleteUser(@PathVariable String idToBeDeleted) {
        Optional<User> existingUser = repository.findById(idToBeDeleted);
        
        if (existingUser.isPresent()) {
            repository.deleteById(idToBeDeleted);
            return "User with id " + idToBeDeleted + " deleted";
            
        } else {
            return "User does not exist";
        }
    }
    
    @GetMapping("/user/getbynameandage/{name}/{age}")
    public List<User> getUserByTwoParams(@PathVariable String name, String age) {
        return repository.getUserByNameAndAge(name, age);
    }
    
    @GetMapping("/user/count/{name}")
    public long countUsersByName(@PathVariable String name) {
        return repository.countByName(name);
    }
}