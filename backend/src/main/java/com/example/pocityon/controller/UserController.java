package com.example.pocityon.controller;

import com.example.pocityon.model.User;
import com.example.pocityon.request.CreateUserRequest;
import com.example.pocityon.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody CreateUserRequest req){
        return userService.createUser(req);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,
                           @RequestBody CreateUserRequest req){
        return userService.updateUser(id, req);
    }

    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
