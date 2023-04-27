package com.pythonbot.blog.blog_app_api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    @Column(name = "user_name", nullable = false, length =100 )
    private String name;
    @Column(name = "email", nullable = false, length = 200)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "about", nullable = false)
    private String about;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts= new ArrayList<>();
}
