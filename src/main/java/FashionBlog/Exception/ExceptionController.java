package FashionBlog.Exception;

import FashionBlog.Dto.APIResponse;
import FashionBlog.Exception.CommentException.CommentNotFoundException;
import FashionBlog.Exception.LikesException.LikeNotFoundException;
import FashionBlog.Exception.PostException.PostNotFoundException;
import FashionBlog.Exception.UserException.AuthenticationException;
import FashionBlog.Exception.UserException.UserFoundException;
import FashionBlog.Exception.UserException.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    // For REST APIs
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> UserNotFoundException(UserNotFoundException ex) {
        return new ResponseEntity<>(new APIResponse(ex.getMessage(),false), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> AuthenticationException(AuthenticationException ex) {
        return new ResponseEntity<>(new APIResponse(ex.getMessage(),false), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<?> PostNotFoundException(PostNotFoundException ex) {
        return new ResponseEntity<>(new APIResponse(ex.getMessage(),false), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(LikeNotFoundException.class)
    public ResponseEntity<?> LikeNotFoundException(LikeNotFoundException ex) {
        return new ResponseEntity<>(new APIResponse(ex.getMessage(),false), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CommentNotFoundException.class)
    public ResponseEntity<?> CommentNotFoundException(CommentNotFoundException ex) {
        return new ResponseEntity<>(new APIResponse(ex.getMessage(),false), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> UserFoundException(UserFoundException ex) {
        return new ResponseEntity<>(new APIResponse(ex.getMessage(),false), HttpStatus.FOUND);
    }
//    @ExceptionHandler(CommentNotFoundException.class)
//    public ResponseEntity<?> CommentNotFoundException(CommentNotFoundException ex) {
//        return new ResponseEntity<>(new APIResponse(ex.getMessage(),false), HttpStatus.NOT_FOUND);
//    }

}