package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    PostRepository postRepository;

    @Override
    public Post create(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post update(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> getByUser(Long userId) {
        return postRepository.findAll().stream()
                .filter(x -> x.getAuthor().getId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
