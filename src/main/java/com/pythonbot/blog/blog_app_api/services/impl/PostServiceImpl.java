package com.pythonbot.blog.blog_app_api.services.impl;

import com.pythonbot.blog.blog_app_api.entities.Category;
import com.pythonbot.blog.blog_app_api.entities.Post;
import com.pythonbot.blog.blog_app_api.entities.User;
import com.pythonbot.blog.blog_app_api.exceptions.ResourceNotFoundException;
import com.pythonbot.blog.blog_app_api.payloads.CategoryDto;
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
import java.util.stream.Collectors;

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
        Post updatePost= this.postRepo.findById(postId).
                orElseThrow(()-> new ResourceNotFoundException("Post", "Post Id", postId));
        updatePost.setTitle(postDto.getTitle());
        updatePost.setContent(postDto.getContent());
        updatePost.setImageName(postDto.getImageName());
        Post newpost=this.postRepo.save(updatePost);
        return this.modelMapper.map(newpost, PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post deletepost= this.postRepo.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post", "postid", postId));
        this.postRepo.delete(deletepost);
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> postList= this.postRepo.findAll();
        List<PostDto> postDtoList= postList.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return  postDtoList;

    }

    @Override
    public PostDto getPostById(Integer postId) {
       Post getpost= this.postRepo.findById(postId)
               .orElseThrow(()->new ResourceNotFoundException("Post", "postId", postId));
        return this.modelMapper.map(getpost, PostDto.class);
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        Category cat= this.categoryRepo.findById(categoryId)
                .orElseThrow(()->new  ResourceNotFoundException("Category", "category_id", categoryId));
       List<Post> posts= this.postRepo.findByCategory(cat);
        List<PostDto> postsDto= posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return  postsDto;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        User user= this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("UserId", "userId", userId));
        List<Post> postList= this.postRepo.findByUser(user);
        return postList.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        return null;
    }
}
