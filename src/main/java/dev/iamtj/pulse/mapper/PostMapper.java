package dev.iamtj.pulse.mapper;

import dev.iamtj.pulse.dtos.PostRequest;
import dev.iamtj.pulse.dtos.PostResponse;
import dev.iamtj.pulse.models.Community;
import dev.iamtj.pulse.models.Post;
import dev.iamtj.pulse.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "postRequest.description")
    Post map(PostRequest postRequest, Community community, User user);


    public abstract PostResponse mapToDto(Post post);

}
