package dev.iamtj.pulse.mapper;

import dev.iamtj.pulse.dtos.CommunityDto;
import dev.iamtj.pulse.models.Community;
import dev.iamtj.pulse.models.Post;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommunityMapper {

    @Mapping(target = "postCount", expression = "java(mapPosts(community.getPosts()))")
    CommunityDto toCommunityDto(Community community);

    default Integer mapPosts(List<Post> numberOfPosts) { return numberOfPosts.size(); }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    Community toCommunity(CommunityDto communityDto);

}
