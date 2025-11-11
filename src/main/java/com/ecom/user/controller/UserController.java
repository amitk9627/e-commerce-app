package com.ecom.user.controller;

import com.ecom.user.model.User;
import com.ecom.security.JwtUtil;
import com.ecom.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try{
            User createdUser = userService.registerUser(user);
            System.out.println("success");
            return ResponseEntity.ok(createdUser);
        }catch(Exception error) {
            System.out.println(error.getMessage());
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User requestUser ) {
        try{
            User user= userService.login(requestUser);
            return ResponseEntity.ok(user);
        }catch(Exception error){
            System.out.println(error.getMessage());
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestParam("user_id") Long userId){
        try {
            userService.logout(userId);
            return ResponseEntity.ok("User logged out successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
