package com.pythonbot.blog.blog_app_api.services;


import com.pythonbot.blog.blog_app_api.payloads.UserDto;
import com.pythonbot.blog.blog_app_api.services.impl.UserServiceImpl;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);

    UserDto getUserBYiD(Integer userId);

    List<UserDto> getAllUser();

    void deleteUser( Integer userId);


}
