package com.company.projects.test.controller;


import com.company.projects.test.model.Post;
import com.company.projects.test.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller để xử lý các yêu cầu HTTP liên quan đến Post
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    // Lấy danh sách tất cả các bài viết
    @GetMapping
    public List<Post> getPosts() {
        System.out.println("Controller getPosts is running.");
        return postService.getPosts();
    }

    // Lấy thông tin chi tiết của một bài viết theo ID
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    // Tạo một bài viết mới
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    // Cập nhật thông tin của một bài viết theo ID
    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    // Xóa một bài viết theo ID
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

    // Tìm kiếm các bài viết theo từ khóa
    @GetMapping("/search")
    public List<Post> searchPosts(@RequestParam String query) {
        return postService.searchPosts(query);
    }
}
