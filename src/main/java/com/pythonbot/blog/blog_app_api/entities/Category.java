package com.pythonbot.blog.blog_app_api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer categoryId;
    @Column(name = "title", length = 100, nullable = false)
    private  String categoryTitle;

    @Column(name = "description")
    private String categoryDescription;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts= new ArrayList<>();

}
