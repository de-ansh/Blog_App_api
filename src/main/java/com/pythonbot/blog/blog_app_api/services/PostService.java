package com.pythonbot.blog.blog_app_api.services;

import com.pythonbot.blog.blog_app_api.entities.Post;
import com.pythonbot.blog.blog_app_api.payloads.PostDto;

import java.util.List;

public interface PostService {
    Post createpost(PostDto postDto);

    Post updatePost( PostDto postDto,Integer postId );

    void deletePost(Integer postId);

    List<Post> getAllPost();

    Post getPostById(Integer postId);

    List<Post> getPostByCategory(Integer categoryId);

    List<Post> getPostByUser(Integer userId);

    List<Post> searchPosts(String keyword);
}
