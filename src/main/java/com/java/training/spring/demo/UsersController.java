package com.java.training.spring.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @GetMapping("/")
    public String appInfo(){
        return "Spring Demo Application is running!\n" +
               "Available APIs:\n" +
               "- GET /api/users - Get all users\n" +
               "- GET /api/users/{id} - Get user by ID\n" +
               "- POST /api/users - Create new user\n" +
               "- PUT /api/users/{id} - Update user\n" +
               "- DELETE /api/users/{id} - Delete user\n" +
               "- GET /api/users/search?name={name} - Search users by name\n" +
               "- GET /api/users/age-range?minAge={min}&maxAge={max} - Get users by age range\n" +
               "- GET /api/users/count - Get user count\n" +
               "- POST /api/users/bulk - Create multiple users\n" +
               "- GET /api/users/health - Health check";
    }

    @GetMapping("/users")
    public String users(){
        return "This endpoint is deprecated. Please use /api/users for the new API.";
    }

}
