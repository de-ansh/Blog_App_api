package com.pythonbot.blog.blog_app_api.payloads;

import com.pythonbot.blog.blog_app_api.entities.Post;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private  int id;
    @NotEmpty
    @Size( min=4, message =  "We need name of minimum of 4 chars")
    private String name;
    @Email(message = "Your email is not valid ")
    private String email;
    @NotEmpty
    @Size(min = 8, message = "Should be at least 8 chars in password")
  //  @Pattern()
    private String password;
    @NotEmpty(message = "About can not be blank")
    private String about;


}
