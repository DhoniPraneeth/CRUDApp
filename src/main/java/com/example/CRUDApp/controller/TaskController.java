package com.example.CRUDApp.controller;

import com.example.CRUDApp.model.Task;
import com.example.CRUDApp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/taskApp")
public class TaskController {
    @Autowired
    TaskService service;
    @PostMapping("/create")
    public ResponseEntity<String> createTask(@RequestBody Task task){
        System.out.println(task);
        Boolean check=service.createTask(task);
        if (!check)
            return new ResponseEntity<>("Task Not Created",HttpStatus.BAD_GATEWAY);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks=service.getAllTasks();
        return new ResponseEntity<>(tasks,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateTask(@RequestBody Task task){
        if(service.updateTask(task))
            return new ResponseEntity<>("Updated Task",HttpStatus.OK);
        return new ResponseEntity<>("Failed to Update",HttpStatus.BAD_GATEWAY);
    }
    @DeleteMapping("/deleteById")
    public ResponseEntity<String> deleteById(@PathVariable String taskCode){
        if(service.deleteTask(taskCode))
            return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
        return new ResponseEntity<>(
                "Delete Failed",HttpStatus.BAD_GATEWAY
        );
    }
}
