package com.pythonbot.blog.blog_app_api.controller;

import com.pythonbot.blog.blog_app_api.payloads.UserDto;
import com.pythonbot.blog.blog_app_api.services.UserService;
import com.pythonbot.blog.blog_app_api.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    //post
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createUser= this.userService.createUser(userDto);
        return  new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }
    //2.56.16
   public  ResponseEntity<UserDto> updateUser(@PathVariable  userId,@RequestBody UserDto userDto ){
        UserDto updateuser= this.userService.updateUser(userId, userDto);
   }
    //put
    //get
    //getbyId
    //delete

}
