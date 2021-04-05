package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task create(Task task) {
        //проверить на валидность
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll().stream().map(x->{
            x.setTimeCreated(x.getTimeCreated() + " gmt+6");
            return x;
        }).collect(Collectors.toList());
    }

    @Override
    public Task update(Task task) {
        //предыдущее значение проверить
        return taskRepository.save(task);
    }

    @Override
    public void delete(Integer id) {
        //проверить что будет если попытаться
        // удалить не сущ элемент
        // если ошибка есть то отловить и обработать
        taskRepository.deleteById(id);
    }

    //создать метод в service "получить данные на сегодня" getTodayTasks
    // добавить mapping в controller
    // использовать stream filter

    @Override
    public List<Task> getTodayTask() {
        return null;
    }

    @Override
    public List<Task> getNewest() {
        List<Task> oldList = taskRepository.findAll();
        List<Task> newList = new ArrayList<>();
        //код для того чтобы вернуть новейшие
        for(int i = oldList.size()-1; i >= 0; i--){
            newList.add(oldList.get(i));
        }
        newList.stream().map(x->{
            x.setTimeCreated(x.getTimeCreated()+ "gmt+6");
            return x;
        }).collect(Collectors.toList());

        return newList;
    }
}
