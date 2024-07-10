// src/main/java/com/petvet/repository/UserRepository.java
package com.petvet.repository;

import com.petvet.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}

