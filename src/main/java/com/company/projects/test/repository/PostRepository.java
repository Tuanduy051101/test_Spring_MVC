package com.company.projects.test.repository;


import com.company.projects.test.model.Post;

import java.util.List;

// Interface định nghĩa các phương thức để thao tác với dữ liệu Post
public interface PostRepository {
    List<Post> findAll();
    Post findById(Long id);
    Post save(Post post);
    Post update(Long id, Post post);
    void delete(Long id);
    List<Post> search(String query);
}
