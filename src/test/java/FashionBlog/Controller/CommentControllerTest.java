package FashionBlog.Controller;

import FashionBlog.Dto.CommentDto;
import FashionBlog.Exception.PostException.PostNotFoundException;
import FashionBlog.Model.Comment;
import FashionBlog.Model.Post;
import FashionBlog.Model.User;
import FashionBlog.Service.Interface.ICommentService;
import FashionBlog.Service.Interface.ILikesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;

@WebMvcTest(CommentController.class)
class CommentControllerTest {
    @MockBean
    private ICommentService commentService;
    @Autowired
    private MockMvc mockMvc;
    static CommentDto commentDto;
    static Comment comment;
    @BeforeEach
    void setUp() {
        User user = new User("Kehinde","Tiamiyu","admin@gmail.com","1234");
        Post post =  new Post("First","First post","url",user);
         comment = Comment.builder()
                .commentBody("First comment")
                .post(post)
                .user(user).build();
        commentDto  = CommentDto.builder()
                .commentBody("This is a comment body")
                .postId(1)
                .userId(1).build();
    }

    @Test
    void createComment() throws Exception {
        Mockito.when(commentService.createComment(commentDto))
                .thenReturn(comment);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/comment/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"commentBody\": \"string\",\n" +
                        "  \"postId\": 1,\n" +
                        "  \"userId\": 1\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void updateComment() throws Exception {
        int commentId = 1;
        Mockito.when(commentService.updateComment(commentDto,commentId)).thenReturn(comment);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/comment/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"commentBody\": \"string\",\n" +
                        "  \"postId\": 2,\n" +
                        "  \"userId\": 2\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isOk());


    }

    @Test
    void deleteComment() throws Exception {
        int commentId = 1;
     Mockito.doNothing().when(commentService).deleteComment(isA(Integer.class));

     mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/comment/1")
             .contentType(MediaType.APPLICATION_JSON))
             .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void getAllCommentsFromAPost() throws Exception {
        List<CommentDto> list = new ArrayList<>();
        CommentDto commentDto1 = new CommentDto("This is the firstcomment body",1,1);
        CommentDto commentDto2 = new CommentDto("This is the second comment body",1,1);
        CommentDto commentDto3 = new CommentDto("This is the third comment body",1,1);
        list.add(commentDto1);
        list.add(commentDto2);
        list.add(commentDto3);

        int postId = 1;
        Mockito.when(commentService.getAllPostComment(postId)).thenReturn(list);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/comment/1")
                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.status().isOk());
    }
}