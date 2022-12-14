package FashionBlog.Repository;

import FashionBlog.Model.Comment;
import FashionBlog.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
    List<Comment> findCommentsByPost(Post post);
}
