package FashionBlog.Repository;

import FashionBlog.Model.Comment;
import FashionBlog.Model.Post;
import FashionBlog.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ActiveProfiles("test")
class CommentRepositoryTest {
@Autowired
    private CommentRepository commentRepository;
@Autowired
private TestEntityManager testEntityManager;
User user = new User("Kehinde","Tiamiyu","admin@gmail.com","1234");
Post post = new Post("first post","this is the post body","http://long",user);
    @BeforeEach
    void setUp() {

        Comment comment = Comment.builder()
                .commentBody("first comment body")
                .user(user)
                .post(post).build();
        testEntityManager.persist(comment);
    }
    @Test
     void whenFindByPostId_thenReturnComment(){
      List<Comment> comment = commentRepository.findCommentsByPost(post);
      assertEquals("first comment body",comment.get(0).getPost());
    }

}