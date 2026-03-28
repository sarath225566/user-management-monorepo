package com.example.user_registration.Repository;

import com.example.user_registration.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // Basic CRUD methods (save, findAll, deleteById) ellam ithil auto-aayi kittum.
}
