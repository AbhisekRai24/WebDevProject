package com.example.resellcompany.service;

import com.example.resellcompany.entity.User;
import com.example.resellcompany.pojo.UserPojo;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveData(UserPojo userPojo);

    List<User>findAll();

    User findbyEmail(String email);

    boolean login(String username, String password);

    User getUserById(Integer id);

    void deleteById(Integer id);


    UserPojo findUserByEmail(String email);

    User updateUser(Integer id, UserPojo userPojo);
}
