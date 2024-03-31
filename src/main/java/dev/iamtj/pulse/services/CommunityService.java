package dev.iamtj.pulse.services;

import dev.iamtj.pulse.dtos.CommunityDto;
import dev.iamtj.pulse.exceptions.SpringPulseException;
import dev.iamtj.pulse.mapper.CommunityMapper;
import dev.iamtj.pulse.models.Community;
import dev.iamtj.pulse.repositories.CommunityRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class CommunityService {

    private final CommunityRepository communityRepository;
    private final CommunityMapper communityMapper;

    @Transactional
    public CommunityDto save(CommunityDto communityDto) {
        Community savedCommunity = communityRepository.save(communityMapper.toCommunity(communityDto));
        communityDto.setId(savedCommunity.getId());
        return communityDto;
    }

    @Transactional(readOnly = true)
    public List<CommunityDto> getAll() {
        return communityRepository.findAll()
                .stream()
                .map(communityMapper::toCommunityDto)
                .collect(toList());
    }

    public CommunityDto getCommunity(Long id) {
        Community community = communityRepository.findById(id)
                .orElseThrow(() -> new SpringPulseException("No Community found with the given id: " + id));
        return communityMapper.toCommunityDto(community);
    }
}
