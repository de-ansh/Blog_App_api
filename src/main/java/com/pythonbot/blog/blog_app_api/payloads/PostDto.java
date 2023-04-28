package com.pythonbot.blog.blog_app_api.payloads;

import com.pythonbot.blog.blog_app_api.entities.Category;
import com.pythonbot.blog.blog_app_api.entities.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private String title;
    private String content;
    private Date addedDate;
    private  String imageName;

    private CategoryDto category;

    private UserDto user;



   // private Date addedDate;





}
