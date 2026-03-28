package com.example.user_registration.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users") // MongoDB-ile table name pole
public class User {
    @Id
    private String id; // MongoDB-il String ID aanu nallath
    private String name;
    private String email;
    private String phone;
    private String department;
}
