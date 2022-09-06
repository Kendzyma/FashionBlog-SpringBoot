package FashionBlog.Controller;

import FashionBlog.Dto.APIResponse;
import FashionBlog.Exception.LikesException.LikeNotFoundException;
import FashionBlog.Exception.PostException.PostNotFoundException;
import FashionBlog.Model.Like;
import FashionBlog.Service.Interface.ILikesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1")
public class LikesController {
    private final ILikesService likesService;

    public LikesController(ILikesService likesService) {
        this.likesService = likesService;
    }
    @ApiOperation(value = "Like Or Unlike A post",response = ResponseEntity.class)
    @PostMapping(value = "/{userEmail}/{postId}",produces = "application/json")
    public ResponseEntity<APIResponse> LikePost(@PathVariable("postId") int postId, @PathVariable("userEmail") String userEmail) throws PostNotFoundException {
        likesService.LikePost(postId,userEmail);
        return new ResponseEntity<>(new APIResponse("success",true), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get all likes in a post",response = ResponseEntity.class)
    @GetMapping(value = "/{postId}",produces = "application/json")
    public ResponseEntity<List<Like>> getAllPostLikes(@PathVariable("postId") int postId) throws LikeNotFoundException, PostNotFoundException {
      return new ResponseEntity<>(likesService.getAllPostLikes(postId),HttpStatus.OK);
    }
}
