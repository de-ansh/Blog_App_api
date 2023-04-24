package com.pythonbot.blog.blog_app_api.repository;

import com.pythonbot.blog.blog_app_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {


}
