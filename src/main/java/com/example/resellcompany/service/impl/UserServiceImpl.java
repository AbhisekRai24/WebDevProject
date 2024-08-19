package com.example.resellcompany.service.impl;

import com.example.resellcompany.entity.User;
import com.example.resellcompany.pojo.UserPojo;
import com.example.resellcompany.repository.UserRepository;
import com.example.resellcompany.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void saveData(UserPojo userPojo) {

        User user = new User();
        user.setUsername(userPojo.getUsername());
        user.setEmail(userPojo.getEmail());
        user.setPassword(userPojo.getPassword());
        user.setAddress(userPojo.getAddress());
        user.setPhone(userPojo.getPhone());

        userRepository.save(user);

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findbyEmail(String email) {
        return userRepository.findByEmail(email);
    }



    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

    }

    @Override
    public void deleteById(Integer id) {

        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.delete(user);
        }

    }

    @Override
    public UserPojo findUserByEmail(String email) {
        User entity = userRepository.findByEmail(email);
        if (entity != null) {
            UserPojo pojo = new UserPojo();
            BeanUtils.copyProperties(entity, pojo);
            return pojo;
        }
        return null;
    }

    @Override
    public User updateUser(Integer id, UserPojo userPojo) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userPojo.getUsername());
        user.setEmail(userPojo.getEmail());
        user.setPassword(userPojo.getPassword());
        user.setPhone(userPojo.getPhone());
        user.setAddress(userPojo.getAddress());
        return userRepository.save(user);
    }

}
