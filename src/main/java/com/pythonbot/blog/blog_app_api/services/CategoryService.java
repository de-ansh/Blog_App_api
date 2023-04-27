package com.pythonbot.blog.blog_app_api.services;

import com.pythonbot.blog.blog_app_api.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    //create
     CategoryDto createCategory(CategoryDto categoryDto);
    //update
      CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
    //delete
    void deleteCategory(Integer categoryId);
    //get
    CategoryDto getCategoryById(Integer categoryId);
    //get all
    List<CategoryDto> getAllCategory();

}
