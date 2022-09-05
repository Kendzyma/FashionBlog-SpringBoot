package FashionBlog.Controller;

import FashionBlog.Dto.APIResponse;
import FashionBlog.Dto.PostDto;
import FashionBlog.Exception.PostException.PostNotFoundException;
import FashionBlog.Service.Interface.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
   private IPostService postService;

    @PostMapping("/")
    public ResponseEntity<APIResponse> createPost(@RequestBody PostDto postDto){
        postService.createPost(postDto);
        return new ResponseEntity<>(new APIResponse("Post added",true), HttpStatus.CREATED);
    }
    @PutMapping("/{postId}")
    public ResponseEntity<APIResponse> updatePost(@RequestBody PostDto postDto, @PathVariable int postId) throws PostNotFoundException {
        postService.updatePost(postDto,postId);
        return new ResponseEntity<>(new APIResponse("Post Updated",true), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<PostDto>> getAllPost(){
        return new ResponseEntity<>(postService.getAllPost(), HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPost(@PathVariable int postId) throws PostNotFoundException {
        return new ResponseEntity<>(postService.getPost(postId), HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<APIResponse> deletePost(@PathVariable int postId){
        postService.deletePost(postId);
        return new ResponseEntity<>(new APIResponse("Post Updated",true), HttpStatus.CREATED);
    }
}
