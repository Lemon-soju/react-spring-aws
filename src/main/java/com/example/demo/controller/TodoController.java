package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TodoDTO;
import com.example.demo.model.TodoEntity;
import com.example.demo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/todo")
public class TodoController {

    private final TodoService service;

    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoDTO dto){
        try{
            String temporaryUserId = "temporary-user";
            TodoEntity tmpEntity = TodoDTO.toEntity(dto);
            tmpEntity.setId(null);
            tmpEntity.setUserId(temporaryUserId);

            TodoEntity entity = service.create(tmpEntity);
            TodoDTO todoDTO = new TodoDTO();
            todoDTO.setId(entity.getId());
            todoDTO.setTitle(entity.getTitle());
            todoDTO.setDone(entity.isDone());

            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setData(todoDTO);
            responseDTO.setError(null);

            return ResponseEntity.ok().body(responseDTO);
        }
        catch (Exception e){
            String error = e.getMessage();

            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setError(error);
            responseDTO.setData(null);

            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @GetMapping
    public ResponseEntity<?> retrieveTodoList(){
        String temporaryUserId = "temporary-user";

        TodoEntity entity = service.retrieve(temporaryUserId);
        TodoDTO dto = new TodoDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDone(entity.isDone());

        return ResponseEntity.ok().body(dto);

    }

    @PutMapping
    public ResponseEntity<?> updateTodo(@RequestBody TodoDTO dto){
        String temporaryUserId = "temporary-user";

        TodoEntity tmpEntity = TodoDTO.toEntity(dto);
        tmpEntity.setUserId(temporaryUserId);
        TodoEntity entity = service.update(tmpEntity);
        TodoDTO todoDto = new TodoDTO();
        todoDto.setId(entity.getId());
        todoDto.setTitle(entity.getTitle());
        todoDto.setDone(entity.isDone());
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setError(null);
        responseDTO.setData(todoDto);

        return ResponseEntity.ok().body(responseDTO);
    }


    @DeleteMapping
    public ResponseEntity<?> deleteTodo(@RequestBody TodoDTO dto){
        try{
            String temporaryUserId = "temporary-user";
            TodoEntity entity = TodoDTO.toEntity(dto);
            entity.setUserId(temporaryUserId);
            TodoEntity tmpEntity = service.delete(entity);
            TodoDTO todoDto = new TodoDTO();
            todoDto.setId(entity.getId());
            todoDto.setTitle(entity.getTitle());
            todoDto.setDone(entity.isDone());
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setError(null);
            responseDTO.setData(todoDto);

            return ResponseEntity.ok().body(responseDTO);
        }
        catch (Exception e){
            String error = e.getMessage();
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setError(error);
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
}
