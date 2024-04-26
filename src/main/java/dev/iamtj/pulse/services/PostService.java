package dev.iamtj.pulse.services;

import dev.iamtj.pulse.dtos.PostRequest;
import dev.iamtj.pulse.dtos.PostResponse;
import dev.iamtj.pulse.exceptions.CommunityNotFoundException;
import dev.iamtj.pulse.exceptions.PostNotFoundException;
import dev.iamtj.pulse.mapper.PostMapper;
import dev.iamtj.pulse.models.Community;
import dev.iamtj.pulse.models.Post;
import dev.iamtj.pulse.models.User;
import dev.iamtj.pulse.repositories.CommunityRepository;
import dev.iamtj.pulse.repositories.PostRepository;
import dev.iamtj.pulse.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class PostService {
    private final CommunityRepository communityRepository;
    private final AuthService authService;
    private final PostMapper postMapper;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Post save(PostRequest postRequest) {
        Community community = communityRepository.findByName(postRequest.getCommunityName()).orElseThrow(() -> new CommunityNotFoundException(postRequest.getCommunityName()));
        User currentUser = authService.getCurrentUser();
        return postMapper.map(postRequest, community, currentUser);
    }

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id.toString()));
        return postMapper.mapToDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll().stream().map(postMapper::mapToDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByCommunity(Long communityId) {
        Community community = communityRepository.findById(communityId).orElseThrow(() -> new CommunityNotFoundException(communityId.toString()));
        List<Post> posts = postRepository.findAllByCommunity(community);
        return posts.stream().map(postMapper::mapToDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return postRepository.findByUser(user).stream().map(postMapper::mapToDto).collect(Collectors.toList());
    }

}
