package dev.iamtj.pulse.controllers;

import dev.iamtj.pulse.dtos.CommunityDto;
import dev.iamtj.pulse.services.CommunityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/community")
@RequiredArgsConstructor
@Slf4j
public class CommunityController {

    private final CommunityService communityService;

    @GetMapping("/greet")
    public String greetCommunity() {
        return "Hello community";
    }

    @GetMapping
    public ResponseEntity<List<CommunityDto>> getAllCommunities() {
        return ResponseEntity.status(HttpStatus.OK).body(communityService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommunityDto> getCommunityById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(communityService.getCommunity(id));
    }

    @PostMapping
    public ResponseEntity<CommunityDto> createCommunity(@RequestBody CommunityDto communityDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(communityService.save(communityDto));
    }

}
