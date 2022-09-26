package FashionBlog.Service;

import FashionBlog.Dto.CommentDto;
import FashionBlog.Exception.PostException.PostNotFoundException;
import FashionBlog.Model.Comment;
import FashionBlog.Model.Post;
import FashionBlog.Model.User;
import FashionBlog.Repository.CommentRepository;
import FashionBlog.Repository.PostRepository;
import FashionBlog.Repository.UserRepository;
import FashionBlog.Service.Interface.ICommentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {
    @MockBean
    private PostRepository postRepository;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private CommentRepository commentRepository;
    @Autowired
    private ICommentService commentService;
static CommentDto commentDto;
static  Comment comment;
    @BeforeEach
    void setUp() throws PostNotFoundException {
        int userId =1;
        int postId = 1;
        User user = User.builder()
                .email("admin@gmail.com")
                .password("1234")
                .lastName("kenny")
                .firstName("tiamiyu").build();
         commentDto = new CommentDto("This is my first comment",userId,postId);


        Post post = Post.builder()
                .postBody("This is the post body")
                .postTitle("This is the post title")
                .url("ur")
                .user(user)
                .user(user).build();
         comment = new Comment("This is my first comment",user,post);
        Mockito.when(postRepository.findById(commentDto.getPostId())).thenReturn(Optional.ofNullable(post));
        Mockito.when(userRepository.findById(commentDto.getUserId())).thenReturn(Optional.ofNullable(user));
    }

    @Test
    void createComment() throws PostNotFoundException {
        Mockito.when(commentRepository.save(comment)).thenReturn(comment);
        User user = new User("admin@gmail.com","kenny","admin@gmail.com","1234");
        Post post = new Post("This is the post body","This is the post title","url",user);
        Comment expected = new Comment("Body",user,post);
      Comment actual =  commentService.createComment(commentDto);

      assertEquals(expected,actual);
    }

    @Test
    void updateComment() {
    }

    @Test
    void deleteComment() {
    }

    @Test
    void getAllPostComment() {
    }
}