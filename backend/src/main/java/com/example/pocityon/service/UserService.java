package com.example.pocityon.service;

import com.example.pocityon.model.User;
import com.example.pocityon.request.CreateUserRequest;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(CreateUserRequest req);
    User updateUser(Long id, CreateUserRequest req);
    void deleteUser(Long id);
    User findUserByUsername(String username) throws Exception;
}
