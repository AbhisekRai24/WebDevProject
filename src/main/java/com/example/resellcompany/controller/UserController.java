package com.example.resellcompany.controller;

import com.example.resellcompany.entity.User;
import com.example.resellcompany.pojo.UserPojo;
import com.example.resellcompany.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public void save(@RequestBody UserPojo userPojo) {
        this.userService.saveData(userPojo);

    }
    @GetMapping("/get")
    public List<User> getall(){
        return this.userService.getAll();
    }






    @PostMapping("/login")
    public boolean login(@RequestBody User request){
        String username=request.getUsername();
        String password=request.getPassword();
        return userService.login(username, password);

    }


}
