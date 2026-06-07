package com.example.CRUDApp.service;

import com.example.CRUDApp.model.Task;
import com.example.CRUDApp.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public boolean updateTask(Task task) {
        return repo.save(task)!=null;
    }

    public boolean deleteTask(String taskCode) {
        Optional<Task> task=repo.findById(taskCode);
        if(task.isPresent()){
            repo.delete(task.get());
            return true;
        }
        return false;
    }

    public Task getById(String taskCode) {
        Optional<Task> t= repo.findById(taskCode);
        if(t.isPresent())
            return t.get();
        return null;
    }
}
