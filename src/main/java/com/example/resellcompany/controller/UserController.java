package com.example.resellcompany.controller;

import com.example.resellcompany.entity.User;
import com.example.resellcompany.pojo.UserPojo;
import com.example.resellcompany.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public void saveData(@RequestBody UserPojo userPojo) {
        this.userService.saveData(userPojo);

    }
    @GetMapping("/get")
    public List<User> findAll(){
        return this.userService.findAll();
    }



    @PostMapping("/login")
    public boolean login(@RequestBody User request){
        String email=request.getEmail();
        String password=request.getPassword();
        return userService.login(email, password);

    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody UserPojo userPojo) {
        return userService.updateUser(id, userPojo);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }



}
