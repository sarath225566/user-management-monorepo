package com.example.user_registration;

import com.example.user_registration.Repository.UserRepository;
import com.example.user_registration.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200") // Angular-inu vendi
public class UserController {
    @Autowired
    private UserRepository userRepository;
    // 1. Register User (Save)
    @PostMapping
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    // 2. Get All Users (List)
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    // 3. Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable String id) {
        userRepository.deleteById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "User deleted successfully!");
        return ResponseEntity.ok(response); // Ithu JSON aayi pokum {"message": "..."}
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User userDetails) {
        User user = userRepository.findById(id).orElseThrow();
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPhone(userDetails.getPhone());
        user.setDepartment(userDetails.getDepartment());

        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }
}
