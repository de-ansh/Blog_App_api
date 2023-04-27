package com.pythonbot.blog.blog_app_api.controller;

import com.pythonbot.blog.blog_app_api.payloads.CategoryDto;
import com.pythonbot.blog.blog_app_api.response.ApiResponse;
import com.pythonbot.blog.blog_app_api.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //Post
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto)
    {
        CategoryDto createdCategory= this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createdCategory, HttpStatus.CREATED);
    }

    //PUt
    @PutMapping("/{categoryId}")
    public  ResponseEntity<CategoryDto> updateCategory(@Valid @PathVariable Integer categoryId, @RequestBody CategoryDto categoryDto){
        CategoryDto updatedCategory= this.categoryService.updateCategory(categoryDto, categoryId);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }
    //Delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
        this.categoryService.deleteCategory(categoryId);
        return  new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted Successfuly", true), HttpStatus.OK);
    }
    //GetById
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer categoryId){
        CategoryDto cat= this.categoryService.getCategoryById(categoryId);
        return  new ResponseEntity<CategoryDto>(cat, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategory(){
        List<CategoryDto> categoryDtoList= this.categoryService.getAllCategory();
      return  ResponseEntity.ok(categoryDtoList);

    }

}
