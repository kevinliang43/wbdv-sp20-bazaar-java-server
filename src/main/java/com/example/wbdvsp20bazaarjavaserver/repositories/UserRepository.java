package com.example.wbdvsp20bazaarjavaserver.repositories;

import java.util.List;
import com.example.wbdvsp20bazaarjavaserver.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT user FROM User user WHERE user.id=:userId")
    public User findUserById(@Param("userId") int uid);

    @Query("SELECT user FROM User user WHERE user.email=:email")
    public User findUserByEmail(@Param("email") String email);

    @Query("SELECT user FROM User user WHERE user.username=:username")
    public User findUserByUsername(@Param("username") String username);

    @Query("SELECT user FROM User user")
    public List<User> findAllUsers();

    @Query("SELECT user FROM User user WHERE user.username= BINARY :username AND user.password= BINARY :password")
    public User findUserByCredentials(
            @Param("username") String username,
            @Param("password") String password
    );
}