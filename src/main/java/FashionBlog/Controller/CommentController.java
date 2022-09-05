package FashionBlog.Controller;

import FashionBlog.Dto.APIResponse;
import FashionBlog.Dto.CommentDto;
import FashionBlog.Exception.PostException.PostNotFoundException;
import FashionBlog.Service.Interface.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;
    @PostMapping("/")
    public ResponseEntity<APIResponse> createComment(@RequestBody CommentDto commentDto) throws PostNotFoundException {
        commentService.createComment(commentDto);
        return new ResponseEntity<>(new APIResponse("Comment added",true), HttpStatus.CREATED);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity updateComment(@RequestBody CommentDto commentDto,@PathVariable int commentId) throws PostNotFoundException {
        commentService.updateComment(commentDto,commentId);
        return new ResponseEntity<>(new APIResponse("Comment updated",true), HttpStatus.OK);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity deleteComment(@PathVariable int commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(new APIResponse("Comment deleted",true), HttpStatus.OK);
    }

    @GetMapping("{postId}")
    public ResponseEntity<List<CommentDto>> getAllCommentsFromAPost(@PathVariable int postId) throws PostNotFoundException {
        return new ResponseEntity<>( commentService.getAllPostComment(postId),HttpStatus.OK);
    }
}