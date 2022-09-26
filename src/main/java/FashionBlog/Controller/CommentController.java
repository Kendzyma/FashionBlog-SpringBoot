package FashionBlog.Controller;

import FashionBlog.Dto.APIResponse;
import FashionBlog.Dto.CommentDto;
import FashionBlog.Exception.PostException.PostNotFoundException;
import FashionBlog.Service.Interface.ICommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
@AllArgsConstructor


public class CommentController {

    private final ICommentService commentService;

    @PostMapping(value = "/" ,produces = "application/json")
    public ResponseEntity<APIResponse> createComment(@RequestBody CommentDto commentDto) throws PostNotFoundException{
        return new ResponseEntity<>(new APIResponse("Comment added",true,commentService.createComment(commentDto)), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{commentId}",produces = "application/json")
    public ResponseEntity<APIResponse> updateComment(@RequestBody CommentDto commentDto,@PathVariable int commentId) throws PostNotFoundException {

        return new ResponseEntity<>(new APIResponse("Comment updated",true, commentService.updateComment(commentDto,commentId)), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{commentId}",produces = "application/json")
    public ResponseEntity<APIResponse> deleteComment(@PathVariable int commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(new APIResponse("Comment deleted",true), HttpStatus.OK);
    }

    @GetMapping(value = "/{postId}",produces = "application/json")
    public ResponseEntity<List<CommentDto>> getAllCommentsFromAPost(@PathVariable int postId) throws PostNotFoundException {
        return new ResponseEntity<>( commentService.getAllPostComment(postId),HttpStatus.OK);
    }
}