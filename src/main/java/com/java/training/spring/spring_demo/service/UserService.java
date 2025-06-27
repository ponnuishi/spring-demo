package com.java.training.spring.spring_demo.service;

import com.java.training.spring.spring_demo.model.User;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {
    
    private final Map<Long, User> users = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);
    
    // Initialize with some sample data
    public UserService() {
        // Add some sample users
        createUser(new User("John Doe", "john@example.com", 30));
        createUser(new User("Jane Smith", "jane@example.com", 25));
        createUser(new User("Bob Johnson", "bob@example.com", 35));
    }
    
    // Create a new user
    public User createUser(User user) {
        Long id = idCounter.getAndIncrement();
        user.setId(id);
        users.put(id, user);
        return user;
    }
    
    // Get all users
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
    
    // Get user by ID
    public User getUserById(Long id) {
        return users.get(id);
    }
    
    // Update user
    public User updateUser(Long id, User userDetails) {
        User existingUser = users.get(id);
        if (existingUser != null) {
            existingUser.setName(userDetails.getName());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setAge(userDetails.getAge());
            return existingUser;
        }
        return null;
    }
    
    // Delete user
    public boolean deleteUser(Long id) {
        return users.remove(id) != null;
    }
    
    // Search users by name
    public List<User> searchUsersByName(String name) {
        return users.values().stream()
                .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
    
    // Get users by age range
    public List<User> getUsersByAgeRange(int minAge, int maxAge) {
        return users.values().stream()
                .filter(user -> user.getAge() >= minAge && user.getAge() <= maxAge)
                .toList();
    }
    
    // Get total count of users
    public long getUserCount() {
        return users.size();
    }
} 