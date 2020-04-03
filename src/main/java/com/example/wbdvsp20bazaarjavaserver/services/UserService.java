package com.example.wbdvsp20bazaarjavaserver.services;
import com.example.wbdvsp20bazaarjavaserver.models.User;
import com.example.wbdvsp20bazaarjavaserver.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }

    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    public User findUserById(int uid) {
        return userRepository.findUserById(uid);
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public int deleteUser(int uid) {
        try {
            userRepository.deleteById(uid);
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public int updateUser(int uid, User newUser) {
        try {
            userRepository.save(newUser);
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
}