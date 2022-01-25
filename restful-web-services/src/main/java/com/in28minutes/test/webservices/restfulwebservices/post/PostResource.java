package com.in28minutes.test.webservices.restfulwebservices.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PostResource {

    @Autowired
    private PostDaoService service;

    @GetMapping("/posts/user/{userId}")
    public List<Post> retrieveAllPosts(@PathVariable int userId) {
        return service.findByUserId(userId);
    }

    @GetMapping("/posts/{id}")
    public Post retrievePost(@PathVariable int id) {
        Post Post = service.findOne(id);
        if (Post == null) {
            throw new PostNotFoundException("id-" + id);
        }
        return Post;
    }

    @PostMapping("/posts")
    public ResponseEntity<Object> createPost(@RequestBody Post Post) {
        Post savedPost = service.save(Post);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
