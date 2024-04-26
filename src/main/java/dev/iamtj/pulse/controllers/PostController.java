package dev.iamtj.pulse.controllers;

import dev.iamtj.pulse.dtos.PostRequest;
import dev.iamtj.pulse.dtos.PostResponse;
import dev.iamtj.pulse.models.Post;
import dev.iamtj.pulse.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/")
    public ResponseEntity<Post> createPost(@RequestBody PostRequest postRequest) {
        return new ResponseEntity<>(postService.save(postRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(postService.getPost(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("by-community/{id}")
    public ResponseEntity<List<PostResponse>> getPostsByCommunity(@PathVariable("id") Long id) {
        return new ResponseEntity<>(postService.getPostsByCommunity(id), HttpStatus.OK);
    }

    @GetMapping("/by-user/{name}")
    public ResponseEntity<List<PostResponse>> getPostsByUser(@PathVariable("name") String name) {
        return new ResponseEntity<>(postService.getPostsByUsername(name), HttpStatus.OK);
    }

}
