package com.in28minutes.test.webservices.restfulwebservices.post;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostDaoService {
    private static int postCount = 8;

    private static final List<Post> posts = new ArrayList<>();

    static {
        posts.add(new Post(1, 1, "Blog Post#1-1", "Blog Post Description"));
        posts.add(new Post(2, 1, "Blog Post#1-1", "Blog Post Description"));
        posts.add(new Post(3, 2, "Blog Post#3-2", "Blog Post Description"));
        posts.add(new Post(4, 2, "Blog Post#4-2", "Blog Post Description"));
        posts.add(new Post(5, 1, "Blog Post#5-1", "Blog Post Description"));
        posts.add(new Post(6, 1, "Blog Post#6-1", "Blog Post Description"));
        posts.add(new Post(7, 1, "Blog Post#7-1", "Blog Post Description"));
        posts.add(new Post(8, 1, "Blog Post#8-1", "Blog Post Description"));
    }

    public List<Post> findByUserId(int userId) {
        List<Post> user_posts = new ArrayList<>();
        for (Post post : posts) {
            if (post.getUserId() == userId) {
                user_posts.add(post);
            }
        }
        return user_posts;
    }

    public Post save(Post post) {
        if (post.getId() == null) {
            post.setId(++postCount);
        }
        posts.add(post);
        return post;
    }

    public Post findOne(int id) {
        for (Post post : posts) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

}
