package FashionBlog.Controller;

import FashionBlog.Dto.APIResponse;
import FashionBlog.Exception.LikesException.LikeNotFoundException;
import FashionBlog.Exception.PostException.PostNotFoundException;
import FashionBlog.Model.Like;
import FashionBlog.Service.Interface.ILikesService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1")
//@ApiResponses(value = {
//        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
//        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
//        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
//})

public class LikesController {
    private final ILikesService likesService;

    public LikesController(ILikesService likesService) {
        this.likesService = likesService;
    }
  //  @ApiOperation(value = "Like Or Unlike A post",response = ResponseEntity.class)
    @PostMapping(value = "/{userId}/{postId}",produces = "application/json")
    public ResponseEntity<APIResponse> LikePost(@PathVariable("postId") int postId, @PathVariable("userId") int userId) throws PostNotFoundException {
        likesService.LikePost(postId,userId);
        return new ResponseEntity<>(new APIResponse("success",true), HttpStatus.CREATED);
    }

   // @ApiOperation(value = "Get all likes in a post",response = ResponseEntity.class)
    @GetMapping(value = "/{postId}",produces = "application/json")
    public ResponseEntity<List<Like>> getAllPostLikes(@PathVariable("postId") int postId) throws LikeNotFoundException, PostNotFoundException {
      return new ResponseEntity<>(likesService.getAllPostLikes(postId),HttpStatus.OK);
    }
}
