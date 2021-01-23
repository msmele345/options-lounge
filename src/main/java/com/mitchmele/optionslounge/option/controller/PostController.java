package com.mitchmele.optionslounge.option.controller;

import com.mitchmele.optionslounge.option.model.Post;
import com.mitchmele.optionslounge.option.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getPosts();
    }

    @PostMapping("/post")
    public String savePost(@RequestBody Post post) {
        postService.savePost(post);
        return "Success";
    }
}
