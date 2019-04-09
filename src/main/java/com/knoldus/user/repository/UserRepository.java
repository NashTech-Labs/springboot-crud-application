package com.knoldus.user.repository;

import com.knoldus.user.models.User;
import org.springframework.stereotype.Component;

/**
 * CRUD operations for the user.
 */
@Component
public class UserRepository {
    
    public User getUserById(String id) {
        return User.builder().id("1").name("Shivangi").age("26").build();
    }
    
    public User addUser(String id, String name, String age){
        return User.builder().id(id).name(name).age(age).build();
    }
    
    public User updateUser(User user) {
        return null;
    }
    
    public boolean deleteUser(String id) {
        return false;
    }
}
