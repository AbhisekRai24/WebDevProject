package com.example.resellcompany.service;

import com.example.resellcompany.entity.User;
import com.example.resellcompany.pojo.UserPojo;

import java.util.List;

public interface UserService {
    void saveData(UserPojo userPojo);
    List getAll();
    boolean login(String username, String password);
    User fetchbyId( Integer id);
    void delete(Integer id);


}
