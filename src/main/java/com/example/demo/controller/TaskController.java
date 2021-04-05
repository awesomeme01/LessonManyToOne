package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;
//    @Autowired
//    TaskRepository taskRepository;
    //create
    @PostMapping("/create")
    public Task create(@RequestBody Task task){
        return taskService.create(task);
    }
    //model -> repository -> controller
    //model -> repository -> service <-> controller

    //read
    @GetMapping("/getAll")
    public List<Task> getAll(){
        return taskService.getAll();
    }
    //update
    @PostMapping("/update")
    public Task update(@RequestBody Task task){
        return taskService.update(task);
    }
    @DeleteMapping("/delete/{id}")//.../tasks/delete/2
    public String delete(@PathVariable Integer id){
        taskService.delete(id);
        return "Успешно удалено!";
    }
    @GetMapping("/newest")
    public List<Task> getNewest(){
        return taskService.getNewest();
    }
}
