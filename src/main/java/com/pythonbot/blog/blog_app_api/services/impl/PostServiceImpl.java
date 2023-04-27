package com.pythonbot.blog.blog_app_api.services.impl;

import com.pythonbot.blog.blog_app_api.entities.Post;
import com.pythonbot.blog.blog_app_api.payloads.PostDto;
import com.pythonbot.blog.blog_app_api.repository.PostRepo;
import com.pythonbot.blog.blog_app_api.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Post createpost(PostDto postDto) {
      Post post=  this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");

        return null;
    }

    @Override
    public Post updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<Post> getAllPost() {
        return null;
    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<Post> getPostByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<Post> getPostByUser(Integer userId) {
        return null;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }
}
