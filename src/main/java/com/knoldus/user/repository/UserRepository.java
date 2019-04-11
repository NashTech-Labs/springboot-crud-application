package com.knoldus.user.repository;

import com.knoldus.user.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * CRUD operations for the user.
 */
public interface UserRepository extends CrudRepository<User, String> {
}
