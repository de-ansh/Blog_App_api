package com.pythonbot.blog.blog_app_api.controller;

import com.pythonbot.blog.blog_app_api.entities.Post;
import com.pythonbot.blog.blog_app_api.payloads.PostDto;
import com.pythonbot.blog.blog_app_api.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;
    //create
    @PostMapping("user/{userId}/category/{categoryId}/post")
    public ResponseEntity<PostDto> createpost
            (@RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId){
       PostDto newpost=  this.postService.createpost(postDto, userId, categoryId);
       return new ResponseEntity<PostDto>(newpost,HttpStatus.CREATED);

    }
    //GetByUser
    @GetMapping("user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
        List<PostDto> postDtoList= this.postService.getPostByUser(userId);
        return new ResponseEntity<>(postDtoList, HttpStatus.OK);
    }

    @GetMapping("category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){
        List<PostDto> postDtoList= this.postService.getPostByCategory(categoryId);
        return new ResponseEntity<>(postDtoList, HttpStatus.OK);
    }

    @GetMapping("posts/")
    public ResponseEntity<List<PostDto>> getAllPost(){
        List<PostDto> postDtoList= this.postService.getAllPost();
        return  new ResponseEntity<>(postDtoList,HttpStatus.OK);
    }
    @GetMapping("posts/{postsId}")
    public ResponseEntity<PostDto> getPost(@PathVariable Integer postsId){
        PostDto postDto= this.postService.getPostById(postsId);
        return  new ResponseEntity<>(postDto,HttpStatus.OK);
    }

}
