package com.pythonbot.blog.blog_app_api.services.impl;

import com.pythonbot.blog.blog_app_api.entities.Category;
import com.pythonbot.blog.blog_app_api.exceptions.ResourceNotFoundException;
import com.pythonbot.blog.blog_app_api.payloads.CategoryDto;
import com.pythonbot.blog.blog_app_api.repository.CategoryRepo;
import com.pythonbot.blog.blog_app_api.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
   @Autowired
    private CategoryRepo categoryRepo;
   @Autowired
   private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
      Category cat= this.modelMapper.map(categoryDto, Category.class);
      Category addedCategory= this.categoryRepo.save(cat);
        return this.modelMapper.map(addedCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
       Category cat= this.categoryRepo.findById(categoryId)
               .orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
       cat.setCategoryTitle(categoryDto.getCategoryTitle());
       cat.setCategoryDescription(categoryDto.getCategoryDescription());
       Category upadatedcat= this.categoryRepo.save(cat);
       return this.modelMapper.map(upadatedcat,CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category cat= this.categoryRepo.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
         this.categoryRepo.delete(cat);
    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) {
        Category cat= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId", categoryId));

        return this.modelMapper.map(cat, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
      List<Category> categories= this.categoryRepo.findAll();
      List<CategoryDto> categoryDtoList=categories.stream().map((cat)->this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
        return categoryDtoList;
    }
}
