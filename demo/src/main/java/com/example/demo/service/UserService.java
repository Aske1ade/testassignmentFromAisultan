package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User userDetails) {
        User existing = userRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setName(userDetails.getName());
        existing.setEmail(userDetails.getEmail());
        return userRepository.save(existing);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
