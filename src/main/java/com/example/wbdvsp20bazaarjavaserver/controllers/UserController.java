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
    public int updateUser(HttpSession session,
        @PathVariable int uid,
        @RequestBody User updatedUser) {

        // Allow updates only if the session User Id matches the Id of User being updated OR if it is an admin
        if (((User)session.getAttribute("profile")).getId() == updatedUser.getId()) {
            int updateStatus = this.service.updateUser(uid, updatedUser);
            if (updateStatus == 1) {
                // Update Session profile if the update was successful and the Session matches the session being updated
                session.setAttribute("profile", updatedUser);
            }
            System.out.println("Failing at Point 1");
            return updateStatus;
        }


        else if (((User)session.getAttribute("profile")).getRole().equals("ADMIN")) {
            int updateStatus = this.service.updateUser(uid, updatedUser);
            System.out.println("Failing at Point 2");
            return updateStatus;
        }

        else { // Session User id does not match the id of the user being updated.
            System.out.println("Failing at Point 3");
            return 0;
        }
    }

    @DeleteMapping("/api/users/{uid}")
    public int deleteUser(HttpSession session,
        @PathVariable("uid") int uid) {

        // Allow deletes only if the session User Id matches the Id of User being deleted.
        if (((User)session.getAttribute("profile")).getId() == uid) {
            int deleteStatus = service.deleteUser(uid);
            if (deleteStatus == 1) {
                // Invalidate the session if the delete was successful.
                session.invalidate();
            }
            return deleteStatus;

        }
        else {
            // Session User Id does not match the id of the user being deleted.
            return 0;
        }
    }

}