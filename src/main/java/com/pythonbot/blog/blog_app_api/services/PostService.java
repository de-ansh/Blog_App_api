package com.pythonbot.blog.blog_app_api.services;

import com.pythonbot.blog.blog_app_api.entities.Post;
import com.pythonbot.blog.blog_app_api.payloads.PostDto;

import java.util.List;

public interface PostService {
    PostDto createpost(PostDto postDto, Integer userId, Integer categoryId);

    PostDto updatePost( PostDto postDto,Integer postId );

    void deletePost(Integer postId);

    List<PostDto> getAllPost();

    PostDto getPostById(Integer postId);

    List<PostDto> getPostByCategory(Integer categoryId);

    List<PostDto> getPostByUser(Integer userId);

    List<PostDto> searchPosts(String keyword);
}
