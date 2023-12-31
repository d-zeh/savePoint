package com.devmountain.savePoint.services;

import com.devmountain.savePoint.dtos.UserDto;
import com.devmountain.savePoint.entities.User;
import com.devmountain.savePoint.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//Add a new user
//Login
//Pull up user's bio page
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public List<String> addUser(UserDto userDto) {
        List<String> response = new ArrayList<>();
        User user = new User(userDto);
        userRepository.saveAndFlush(user);
        response.add("User Added Successfully");
        return response;
    }

    @Override
    public List<String> userLogin(UserDto userDto) {
        List<String> response = new ArrayList<>();
        Optional<User> userOptional = userRepository.findByUsername(userDto.getUsername());
        if(userOptional.isPresent()) {
            if(passwordEncoder.matches(userDto.getPassword(), userOptional.get().getPassword())) {
                response.add("User Login Successful");
                response.add(String.valueOf(userOptional.get().getId()));
            } else {
                response.add("Username or password Incorrect");
            }
        } else {
            response.add("Username or password Incorrect");
        }
        return response;
    }

}
