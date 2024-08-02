package com.company.projects.test.service;

import com.company.projects.test.model.Post;
import com.company.projects.test.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service để xử lý logic nghiệp vụ liên quan đến Post
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id);
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post post) {
        return postRepository.update(id, post);
    }

    public void deletePost(Long id) {
        postRepository.delete(id);
    }

    public List<Post> searchPosts(String query) {
        return postRepository.search(query);
    }
}
