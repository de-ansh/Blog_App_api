package com.pythonbot.blog.blog_app_api.services.impl;

import com.pythonbot.blog.blog_app_api.entities.User;
import com.pythonbot.blog.blog_app_api.exceptions.*;
import com.pythonbot.blog.blog_app_api.payloads.UserDto;
import com.pythonbot.blog.blog_app_api.repository.UserRepo;
import com.pythonbot.blog.blog_app_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDto createUser(UserDto userdto) {
        User user = this.dtotoUser( userdto);
        User savedUser= this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user= this.userRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("user", "id", userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updatedUser= this.userRepo.save(user);

        return this.userToDto(updatedUser);
    }

    @Override
    public UserDto getUserBYiD(Integer userId) {
        User user= this.userRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("user", "id", userId));

        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users=this.userRepo.findAll();
        List<UserDto> userDtoList=users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user= this.userRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User", "id", userId));
        this.userRepo.delete(user);
    }

    private User dtotoUser(UserDto userDto){
        User user= new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        return  user;
    }

    public  UserDto userToDto(User user){
        UserDto userDto= new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());

        return userDto;
    }


}
