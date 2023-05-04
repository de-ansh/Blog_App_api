package com.pythonbot.blog.blog_app_api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table (name = "Posts")
@Getter
@Setter
@NoArgsConstructor
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @Column(name = "post_title",length = 150, nullable = false)

    private String title;
    @Column(name = "post_Content", nullable = false, length = 10000)
    private String content;
    @Column(name = "post_Image")
    private  String imageName;
    @Column(name = "post_Date")
    private Date addedDate;

    @ManyToOne
    @JoinColumn(name = "post_category_id")
    private Category category;
    @ManyToOne
    private  User user;

}
