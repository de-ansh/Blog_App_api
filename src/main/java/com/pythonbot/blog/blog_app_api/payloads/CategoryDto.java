package com.pythonbot.blog.blog_app_api.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private  Integer categoryId;
    @NotEmpty
    @Size( min=4, message =  "We need name of minimum of 4 chars")
    private  String categoryTitle;
    @NotEmpty
    @Size( min=3, message =  "We need name of minimum of 4 chars")
    private String categoryDescription;
}
