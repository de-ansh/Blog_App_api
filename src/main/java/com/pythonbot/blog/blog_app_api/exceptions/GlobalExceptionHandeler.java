package com.pythonbot.blog.blog_app_api.exceptions;

import com.pythonbot.blog.blog_app_api.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandeler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> ressourceNotFoundExceptionHandeler(ResourceNotFoundException ex){
       String messages= ex.getMessage();
       ApiResponse apiResponse= new ApiResponse(messages, false);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity<Map<String, String>> handleMEthodArgnotValidException(MethodArgumentNotValidException ex){
        Map<String, String> resp= new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldname=((FieldError)error).getField();
            String message= error.getDefaultMessage();
            resp.put(fieldname,message);
        });
        return  new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
    }
    //4.10

}
