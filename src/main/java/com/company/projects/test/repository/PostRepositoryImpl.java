package com.company.projects.test.repository;

import com.company.projects.test.model.Post;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Implementation của PostRepository để thao tác với JSONPlaceholder API
@Repository
public class PostRepositoryImpl implements PostRepository {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${jsonplaceholder.api.url}")
    private String apiUrl;

    @Override
    public List<Post> findAll() {
        Post[] posts = restTemplate.getForObject(apiUrl, Post[].class);
        System.out.println("Runnung");
        System.out.println(posts);
        return Arrays.asList(posts);
    }

    @Override
    public Post findById(Long id) {
        return restTemplate.getForObject(apiUrl + "/" + id, Post.class);
    }

    @Override
    public Post save(Post post) {
        return restTemplate.postForObject(apiUrl, post, Post.class);
    }

    @Override
    public Post update(Long id, Post post) {
        restTemplate.put(apiUrl + "/" + id, post);
        return post;
    }

    @Override
    public void delete(Long id) {
        restTemplate.delete(apiUrl + "/" + id);
    }

    @Override
    public List<Post> search(String query) {
        return findAll().stream()
                .filter(post -> post.getTitle().contains(query) || post.getBody().contains(query))
                .collect(Collectors.toList());
    }
}
