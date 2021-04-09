package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userApi")
public class UserController {
    @Autowired
    UserService userService;

    //    User create(User user);
    //    User update(User user);
    //    List<User> getAll();
    //    User getById(Long id);
    //    void delete(Long id);

    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAll();
    }

}
