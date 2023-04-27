package com.pythonbot.blog.blog_app_api.repository;

import com.pythonbot.blog.blog_app_api.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
