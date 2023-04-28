package com.pythonbot.blog.blog_app_api.services.impl;

import com.pythonbot.blog.blog_app_api.entities.Category;
import com.pythonbot.blog.blog_app_api.entities.Post;
import com.pythonbot.blog.blog_app_api.entities.User;
import com.pythonbot.blog.blog_app_api.exceptions.ResourceNotFoundException;
import com.pythonbot.blog.blog_app_api.payloads.PostDto;
import com.pythonbot.blog.blog_app_api.repository.CategoryRepo;
import com.pythonbot.blog.blog_app_api.repository.PostRepo;
import com.pythonbot.blog.blog_app_api.repository.UserRepo;
import com.pythonbot.blog.blog_app_api.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createpost(PostDto postDto, Integer userId, Integer categoryId) {
      User user= this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "User_Id", userId));
        Category category= this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "category_id", categoryId));
      Post post=  this.modelMapper.map(postDto, Post.class);
      post.setImageName("default.png");
      post.setAddedDate(new Date());
      post.setUser(user);
      post.setCategory(category);
     Post newpost= this.postRepo.save(post);
        return this.modelMapper.map(newpost,PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<PostDto> getAllPost() {
        return null;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        return null;
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        return null;
    }
}
