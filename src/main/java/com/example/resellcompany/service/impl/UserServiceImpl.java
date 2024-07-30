package com.example.resellcompany.service.impl;

import com.example.resellcompany.entity.User;
import com.example.resellcompany.pojo.UserPojo;
import com.example.resellcompany.repository.UserRepository;
import com.example.resellcompany.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void saveData(UserPojo userPojo) {

        User user = new User();

        user.setId(userPojo.getId());
        user.setUsername(userPojo.getUsername());
        user.setPassword(userPojo.getPassword());

        userRepository.save(user);

    }

    @Override
    public List getAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public User fetchbyId(Integer id) {
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));

    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }


}
