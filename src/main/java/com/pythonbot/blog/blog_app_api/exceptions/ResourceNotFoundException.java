package com.pythonbot.blog.blog_app_api.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends  RuntimeException{
    String resourceName;
    String fieldName;

    Integer fieldvalue;

    public ResourceNotFoundException(String resourceName, String fieldName, Integer fieldvalue){
        super(String.format("%not found with %s : %1",resourceName, fieldName,fieldvalue ));

        this.resourceName= resourceName;
        this.fieldName= fieldName;
        this.fieldvalue= fieldvalue;
    }


}
