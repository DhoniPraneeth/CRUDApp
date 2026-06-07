package com.example.CRUDApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class TaskController {
    @GetMapping("/createTask")
    public ResponseEntity<String> createTask(){

    }
}
