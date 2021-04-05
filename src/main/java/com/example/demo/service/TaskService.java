package com.example.demo.service;

import com.example.demo.model.Task;

import java.util.List;

public interface TaskService {
    //c r u d operations
    Task create(Task task);//полчуить обьект -Ю сохранить -Ю и вернуть сохраненную версию
    List<Task> getAll();
    Task update(Task task);
    void delete(Integer id);
    //Extra operations
    List<Task> getNewest();//получить новейшие
    List<Task> getTodayTask();
}
