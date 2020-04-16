package com.example.wbdvsp20bazaarjavaserver.controllers;
import com.example.wbdvsp20bazaarjavaserver.models.User;
import com.example.wbdvsp20bazaarjavaserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true")
public class UserController {

    @Autowired
    UserService service = new UserService();

    @PostMapping("/api/users")
    public User createUser(HttpSession session,
        @RequestBody User newUser) {
            User user = this.service.createUser(newUser);
            // TODO: We may want to log them in as soon as they register?
            // user.setPassword("***");
            // session.setAttribute("profile", user);
            return user;
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

    @PostMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @PostMapping("/login")
    public User login(HttpSession session,
                      @RequestBody User user) {
        User profile = this.service.findUserByCredentials(user.getUsername(), user.getPassword());
        session.setAttribute("profile", profile);
        return profile;
    }

    @PostMapping("/profile")
    public User profile(HttpSession session) {
        User profile = (User)session.getAttribute("profile");
        return profile;
    }

    @PutMapping("/api/users/{uid}")
    public User updateUser(HttpSession session,
        @PathVariable int uid,
        @RequestBody User updatedUser) {

        if (((User)session.getAttribute("profile")).getId() == updatedUser.getId()) {
            // Allow updates only if the session User Id matches the Id of User being updated
            this.service.updateUser(uid, updatedUser); // TODO: Send different response if update fails on severside.
            // IF IT WORKS
            System.out.println("BEFORE");
            System.out.println(session.getAttribute("profile"));
            session.setAttribute("profile", updatedUser);
            System.out.println("AFTER");
            System.out.println(session.getAttribute("profile"));
            // TODO: if it doesnt work, handle the case here

            //Return
            return updatedUser;
        }
        else {
            return null;
        }
    }

}