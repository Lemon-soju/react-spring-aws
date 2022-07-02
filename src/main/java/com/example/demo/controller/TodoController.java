package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @GetMapping("/test")
    public ResponseDTO testTodo(){
        ResponseDTO response = ResponseDTO.builder().data("hello").build();
        return response;
    }
}
