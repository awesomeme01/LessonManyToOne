package com.example.demo.bootstrap;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class MainBootstrap implements ApplicationRunner {
    @Autowired
    TaskRepository taskRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            Task task2 = new Task("hello world2");
            Task task3 = new Task("hello world3");

            taskRepository.save(task2);
            taskRepository.save(task3);
        }
        catch(DataIntegrityViolationException ex){
            System.out.println("Data error:" + ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Unexpected error!");
            System.out.println(ex.getStackTrace());
        }
        finally {
            System.out.println("MainBootstrap executed!");
        }

    }
}
