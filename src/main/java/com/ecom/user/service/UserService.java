package com.ecom.user.service;

import com.ecom.security.JwtUtil;
import com.ecom.user.model.User;
import com.ecom.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("CUSTOMER");
        return userRepository.save(user);
    }
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
    public User login(User requestUser) {

        Optional<User> dbUser = userRepository.findByEmail(requestUser.getEmail());

        if (dbUser.isEmpty()) {
            throw new RuntimeException("User does not exist!");
        }

        User user = dbUser.get();
        System.out.println(user);
        // Check password
        if (!checkPassword(requestUser.getPassword(), user.getPassword())) {
            throw new RuntimeException("Wrong password!");
        }

        // Generate JWT token
        String token = jwtUtil.generateToken(user.getName());
        user.setToken(token);
        // update token in the DB
        userRepository.save(user);

        return user;
    }
    public void logout(Long userId) {
        Optional<User> dbUser = userRepository.findById(userId);
        if (dbUser.isEmpty()) {
            throw new RuntimeException("User not found!");
        }
        User user = dbUser.get();
        user.setToken(null); // clear the token
        userRepository.save(user);
    }
    public User findById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user;
    }
}
