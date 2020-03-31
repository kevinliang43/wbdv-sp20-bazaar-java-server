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

    @PutMapping("/api/users/{uid}")
    public int updateTopic(
        @PathVariable int uid, 
        @RequestBody User user) {
            return this.service.updateUser(uid, user);
    }

    @DeleteMapping("/api/users/{uid}")
    public int deleteTopic(
        @PathVariable int uid) {
            return this.service.deleteUser(uid);
    }
}