package com.example.pocityon.service.impl;

import com.example.pocityon.model.User;
import com.example.pocityon.model.UserRole;
import com.example.pocityon.repository.UserRepository;
import com.example.pocityon.request.CreateUserRequest;
import com.example.pocityon.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User createUser(CreateUserRequest req) {
        User user = new User();

        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());
        user.setRole(req.getRole());
        user.setImage(req.getImage());
        user.setBio(req.getBio());
        user.setSocialLinks(req.getSocialLinks());
        user.setPosts(req.getPosts());
        user.setSuggestions(req.getSuggestions());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, CreateUserRequest req) {
        User user = userRepository.findById(id).orElseThrow();

        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());
        user.setRole(req.getRole());
        user.setImage(req.getImage());
        user.setBio(req.getBio());
        user.setSocialLinks(req.getSocialLinks());
        user.setPosts(req.getPosts());
        user.setSuggestions(req.getSuggestions());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findUserByUsername(String username) throws Exception {
        return userRepository.findByUsername(username);
    }
}
