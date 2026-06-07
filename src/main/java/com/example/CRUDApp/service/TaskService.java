package com.example.CRUDApp.service;

import com.example.CRUDApp.model.Task;
import com.example.CRUDApp.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepository repo;
    public Boolean createTask(Task task) {
        Task t=repo.save(task);
        if(t==null){
            return false;
        }
        return true;
    }

    public List<Task> getAllTasks() {
        return repo.findAll();
    }
}
