package com.example.wbdvsp20bazaarjavaserver.controllers;
import com.example.wbdvsp20bazaarjavaserver.models.User;
import com.example.wbdvsp20bazaarjavaserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService service = new UserService();

    @PostMapping("/api/users")
    public User createUser(
        @RequestBody User newUser) {
            return this.service.createUser(newUser);
    } 

    @GetMapping("/api/users")
    public List<User> findAllUsers() {
            return this.service.findAllUsers();
    }

    @GetMapping("/api/users/{uid}")
    public User findUserById(
        @PathVariable int uid) {
            return this.service.findUserById(uid);
    }

    @GetMapping("/api/users/email/{email}")
    public User findUserByEmail(
        @PathVariable String email) {
            return this.service.findUserByEmail(email);
    }

    @GetMapping("/api/users/username/{username}")
    public User findUserByUsername(
        @PathVariable String username) {
            return this.service.findUserByUsername(username);
    }
}