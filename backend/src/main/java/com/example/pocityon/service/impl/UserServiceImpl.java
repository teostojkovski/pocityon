package com.example.pocityon.service.impl;

import com.example.pocityon.model.User;
import com.example.pocityon.repository.UserRepository;
import com.example.pocityon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByEmail(String email) throws Exception {
        User user = userRepository.findByEmail(email);
        if(user==null) {
            throw new Exception("User not found");
        }
        return user;
    }
}
