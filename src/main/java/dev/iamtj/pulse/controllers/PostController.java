package dev.iamtj.pulse.controllers;

import dev.iamtj.pulse.dtos.PostRequest;
import dev.iamtj.pulse.dtos.PostResponse;
import dev.iamtj.pulse.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/")
    public ResponseEntity createPosts(@RequestBody PostRequest postRequest) {
        postService.save(postRequest);
        return null;
    }

    @GetMapping("/{id}")
    public PostResponse getPostById(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping("/")
    public List<PostResponse> getAllPosts() {
        return null;
    }

    @GetMapping("by-community/{id}")
    public List<PostResponse> getPostsByCommunity(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping("/by-user/{name}")
    public List<PostResponse> getPostsByUser(@PathVariable("name") String name) {
        return null;
    }

}
