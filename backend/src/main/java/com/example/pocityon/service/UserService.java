package com.example.pocityon.service;

import com.example.pocityon.model.User;

public interface UserService {
    public User findUserByEmail(String email) throws Exception;
}
