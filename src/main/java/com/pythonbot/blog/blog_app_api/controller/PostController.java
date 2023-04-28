package com.pythonbot.blog.blog_app_api.controller;

import com.pythonbot.blog.blog_app_api.entities.Post;
import com.pythonbot.blog.blog_app_api.payloads.PostDto;
import com.pythonbot.blog.blog_app_api.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("user/{userId}/category/{categoryId}/post")
    public ResponseEntity<PostDto> createpost
            (@RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId){
       PostDto newpost=  this.postService.createpost(postDto, userId, categoryId);
       return new ResponseEntity<PostDto>(newpost,HttpStatus.CREATED);

    }

}
