package dev.iamtj.pulse.repositories;

import dev.iamtj.pulse.models.Community;
import dev.iamtj.pulse.models.Post;
import dev.iamtj.pulse.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByCommunity(Community community);
    List<Post> findByUser(User user);
}
