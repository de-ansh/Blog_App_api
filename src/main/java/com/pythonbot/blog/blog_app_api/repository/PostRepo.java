package com.pythonbot.blog.blog_app_api.repository;

import com.pythonbot.blog.blog_app_api.entities.Category;
import com.pythonbot.blog.blog_app_api.entities.Post;
import com.pythonbot.blog.blog_app_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);
    List<Post>  findByCategory(Category category);
}
