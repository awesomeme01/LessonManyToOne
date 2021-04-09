package com.example.demo.bootstrap;

import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.service.PostService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MainBootstrap implements ApplicationRunner {
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try{
            User user = new User("admin", 18, "admin@gmail.com");
            userService.create(user);
            Post post = new Post("Hellow", "world", user);
            postService.create(post);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
