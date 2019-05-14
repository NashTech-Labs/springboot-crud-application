package com.knoldus.user.repository;

import com.knoldus.user.models.Users;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * CRUD operations for the user.
 */
public interface UserRepository extends CrudRepository<Users, String> {
    
    @Query(allowFiltering = true)
    List<Users> getUserByNameAndAge(String name, String age);
    
    @Query(allowFiltering = true)
    long countByName(String name);
 
}
