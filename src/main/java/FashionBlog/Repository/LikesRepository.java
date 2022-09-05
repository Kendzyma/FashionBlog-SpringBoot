package FashionBlog.Repository;

import FashionBlog.Model.Like;
import FashionBlog.Model.Post;
import FashionBlog.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikesRepository extends JpaRepository<Like,Integer> {
    Optional<Like> findLikeByPostAndUser(Post post, User user);
    void deleteLikeByPostAndUser(Post post,User user);
    Optional<List<Like>> findLikesByPost(Post post);
}
