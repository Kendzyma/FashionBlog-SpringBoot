package FashionBlog.Controller;

import FashionBlog.Dto.APIResponse;
import FashionBlog.Dto.PostDto;
import FashionBlog.Exception.PostException.PostNotFoundException;
import FashionBlog.Service.Interface.IPostService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@AllArgsConstructor


public class PostController {

   private final IPostService postService;

    @PostMapping(value = "/",produces = "application/json")
    public ResponseEntity<APIResponse> createPost(@RequestBody PostDto postDto){

        return new ResponseEntity<>(new APIResponse("Post added",true,postService.createPost(postDto)), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{postId}",produces = "application/json")
    public ResponseEntity<APIResponse> updatePost(@RequestBody PostDto postDto, @PathVariable int postId) throws PostNotFoundException {
        return new ResponseEntity<>(new APIResponse("Post Updated",true,postService.updatePost(postDto,postId)), HttpStatus.CREATED);
    }

    @GetMapping(value = "/",produces = "application/json")
    public ResponseEntity<List<PostDto>> getAllPost(){
        return new ResponseEntity<>(postService.getAllPost(), HttpStatus.OK);
    }

    @GetMapping(value = "/{postId}",produces = "application/json")
    public ResponseEntity<PostDto> getPost(@PathVariable int postId) throws PostNotFoundException {
        return new ResponseEntity<>(postService.getPost(postId), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{postId}",produces = "application/json")
    public ResponseEntity<APIResponse> deletePost(@PathVariable int postId) throws PostNotFoundException {
        postService.deletePost(postId);
        return new ResponseEntity<>(new APIResponse("Post deleted successfully",true), HttpStatus.CREATED);
    }
}
