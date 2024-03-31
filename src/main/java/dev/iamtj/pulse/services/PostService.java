package dev.iamtj.pulse.services;

import dev.iamtj.pulse.dtos.PostRequest;
import dev.iamtj.pulse.exceptions.CommunityNotFoundException;
import dev.iamtj.pulse.models.Community;
import dev.iamtj.pulse.models.User;
import dev.iamtj.pulse.repositories.CommunityRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PostService {
    private final CommunityRepository communityRepository;
    private final AuthService authService;
    public void save(PostRequest postRequest) {
        Community community = communityRepository.findByName(postRequest.getCommunityName()).orElseThrow(() -> new CommunityNotFoundException(postRequest.getCommunityName()));
        //User currentUser = authService.getCurrentUser();
    }
}
