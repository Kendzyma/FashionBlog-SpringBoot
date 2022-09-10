package FashionBlog.Service;

import FashionBlog.Dto.PostDto;
import FashionBlog.Model.Post;
import FashionBlog.Model.User;
import FashionBlog.Repository.PostRepository;
import FashionBlog.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class PostServiceTest {
    @Autowired
   private PostService postService;
    @MockBean
    private  PostRepository postRepository;
    @BeforeEach
    void setUp(){
        List<Post> posts = new ArrayList<>();

        Post post = Post.builder().postTitle("First Post")
                .postBody("This is the first post")
                .url("http://www.pix.com").user(new User()).build();
        Post post2 = Post.builder().postTitle("Second Post")
                .postBody("This is the Second post")
                .url("http://www.pix.com").user(new User()).build();
        posts.add(post);
        posts.add(post2);
        Mockito.when(postRepository.findAll()).thenReturn(posts);
    }


    @Test
    void getAllPostServiceShouldReturnSuccess() {
        List<PostDto> list2 = new ArrayList<>();
        PostDto postDto =new PostDto("First Post","This is the first post","http://www.pix.com");
        PostDto postDto2 =new PostDto("Second Post","This is the Second post","http://www.pix.com");
        list2.add(postDto);
        list2.add(postDto2);
     List<PostDto> list= postService.getAllPost();
        assertEquals(list2,list);
    }
}