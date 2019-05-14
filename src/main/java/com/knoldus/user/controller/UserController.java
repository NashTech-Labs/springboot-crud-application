package com.knoldus.user.controller;

import com.knoldus.user.models.Users;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    
    @Autowired
    private UserRepository repository;
    
    /**
     * Shows the welcome page.
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "Welcome to the CRUD application!!";
    }
    
    /**
     * Finds user by {@param id}
     *
     * @param id userId
     * @return
     */
    @GetMapping("/user/{id}")
    public Optional<Users> getUser(@PathVariable String id) {
        List<Integer> l = new ArrayList<>();
        return repository.findById(id);
    }
    
    /**
     * Adds a new user to the user table.
     *
     * @param newUsers Users to be added.
     * @return
     */
    @PostMapping("/user")
    public Users addUser(@RequestBody Users newUsers) {
        Users bob = Users.builder()
                .id(newUsers.getId())
                .name(newUsers.getName())
                .age(newUsers.getAge())
                .build();
        return repository.save(bob);
    }
    
    /**
     * Update the existing user.
     *
     * @param id   user id to be updated.
     * @param name updated name.
     * @param age  updated age.
     * @return
     */
    @PutMapping("/user/{id}/{name}/{age}")
    public Optional<Users> updateUser(@PathVariable String id, @PathVariable String name, @PathVariable String age) {
        Optional<Users> existingUser = repository.findById(id);
        if (existingUser.isPresent()) {
            Users newUsers = repository.save(Users.builder()
                    .id(id)
                    .name(name)
                    .age(age)
                    .build());
            return Optional.of(newUsers);
        }
        return existingUser;
    }
    
    /**
     * Deletes a particular user.
     *
     * @param idToBeDeleted user id to be deleted.
     * @return
     */
    @DeleteMapping("/user/{idToBeDeleted}")
    public String deleteUser(@PathVariable String idToBeDeleted) {
        Optional<Users> existingUser = repository.findById(idToBeDeleted);
        
        if (existingUser.isPresent()) {
            repository.deleteById(idToBeDeleted);
            return "Users with id " + idToBeDeleted + " deleted";
            
        } else {
            return "Users does not exist";
        }
    }
    
    /**
     * Fetches user by the given name and age.
     *
     * @param name
     * @param age
     * @return
     */
    @GetMapping("/user/{name}/{age}")
    public List<Users> getUserByNameAndAge(@PathVariable String name, @PathVariable String age) {
        return repository.getUserByNameAndAge(name, age);
    }
    
    /**
     * counts number of user with a particular name.
     *
     * @param name
     * @return
     */
    @GetMapping("/user/count/{name}")
    public long countUsersByName(@PathVariable String name) {
        return repository.countByName(name);
    }
}
