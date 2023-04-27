package com.pythonbot.blog.blog_app_api.payloads;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
